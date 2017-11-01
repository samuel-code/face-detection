package com.tanshijun.blog.common.client;

import com.tanshijun.blog.common.dto.ClientInfoDTO;
import com.tanshijun.blog.common.exception.ResponseException;
import com.tanshijun.blog.common.vo.ClientInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tanshijun-pc on 2017/10/31.
 */
public class PutClientInfoInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private UClientService clientService;

    public PutClientInfoInterceptor(UClientService uClientService){
        this.clientService = uClientService;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //移除掉用户信息
        LocalClientInfo.remove();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try{
            logger.info("start query clientInfo....");
            ClientInfoVO clientInfoVO = clientService.queryClientInfo(request);
            LocalClientInfo.set(clientInfoVO);
        }catch(Exception e){
            throw new ResponseException("000003","获取用户信息出错");
        }
        return super.preHandle(request, response, handler);
    }
}
