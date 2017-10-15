package com.tanshijun.blog.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.tanshijun.blog.common.constant.AuthenEnum;
import com.tanshijun.blog.gateway.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tanshijun-pc on 2017/9/28.
 */
@Component
public class AuthenticationFilter extends ZuulFilter {

    @Autowired
    private AuthenticationService authenticationService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public String getFilterUrlPrefix() {
        return filterUrlPrefix;
    }

    public void setFilterUrlPrefix(String filterUrlPrefix) {
        this.filterUrlPrefix = filterUrlPrefix;
    }

    @Value("${authentication.filter.url.prefix}")
    private String filterUrlPrefix;


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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        boolean match = match(uri);
        logger.info("uri:{},是否需要进行认证:{}",uri,match);
        return match;
    }

    /**
     * 判断该请求是否匹配需要进行登录认证
     * @param uri
     * @return
     */
    private boolean match(String uri){
        String[] uriArray = uri.split("/");
        if(uriArray == null || uriArray.length < 3){
            return false;
        }
        String uriPrefix = uriArray[2];
        return uriPrefix.equals(filterUrlPrefix);
    }
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        AuthenEnum authenEnum = authenticationService.authen(request);
        logger.info("authen result:"+authenEnum.getResponseCode()+";"+authenEnum.getDesc());
        if(AuthenEnum.AUHENSUCCESS == authenEnum){
            ctx.setSendZuulResponse(true);// 认证成功，对该请求进行路由
            ctx.setResponseStatusCode(200);
        }else{
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(authenEnum.getHeadCode());
        }
        return null;
    }
}
