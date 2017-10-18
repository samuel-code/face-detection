package com.tanshijun.blog.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.tanshijun.blog.common.constant.AuthenEnum;
import com.tanshijun.blog.common.operation.redis.RedisOperation;
import com.tanshijun.blog.gateway.common.utils.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 对同一个IP进行访问限制
 * Created by tanshijun-pc on 2017/10/17.
 */
@Component
public class LimitAccessFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RedisOperation<Object> redisOperation;
    /**
     * 限制用户访问次数的阈值
     */
    @Value("${limit.access.threshold}")
    private int threshold;
    /**
     * 限制访问次数的单位时间（单位秒）
     */
    @Value("${limit.access.timeUnit}")
    private int timeUnit;
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        logger.info("enter LimitAccessFilter.......");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        if(limit(request)){
            AuthenEnum authenEnum = AuthenEnum.ACCESSLIMIT;
            ctx.setSendZuulResponse(false);//访问次数限制
            //ctx.setResponseStatusCode(authenEnum.getHeadCode());
            JSONObject responseJson = new JSONObject();
            responseJson.put("responseMsg",authenEnum.getDesc());
            responseJson.put("responseCode",authenEnum.getResponseCode());
            ctx.setResponseBody(responseJson.toJSONString());
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/Json");
        }else{
            ctx.setSendZuulResponse(true);// 认证成功，对该请求进行路由
            ctx.setResponseStatusCode(200);
        }
        return null;
    }

    private static final String PREFIX_LIMIT_KEY = "limit:";
    /**
     * 是否应该对限制
     * @param request
     * @return
     */
    private boolean limit(HttpServletRequest request){
        try{
            logger.info("===========limit=============");
            String ip = IpUtils.getIpAddress(request);
            final String key = PREFIX_LIMIT_KEY.concat(ip);
            long accessNum = redisOperation.exec(new RedisCallback<Long>() {
                @Override
                public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {

                    long localAccessNum = 0;
                    byte[] byteKey = key.getBytes();
                    if(redisConnection.exists(byteKey)){
                        localAccessNum = redisConnection.incr(byteKey);
                    }else{
                        redisConnection.multi();
                        redisConnection.incr(byteKey);
                        redisConnection.expire(byteKey,TimeUnit.SECONDS.toMillis(timeUnit));
                        redisConnection.exec();
                    }
                    return localAccessNum;
                }
            });//redisOperation.incr(key, TimeUnit.SECONDS,timeUnit);
            boolean limit = accessNum > threshold;
            logger.info("ip:{} accessNum:{} should limit:{}",ip,accessNum,limit);
            return limit;
        }catch(Exception e){
            logger.error("limit error",e);
            return false;
        }

    }
}
