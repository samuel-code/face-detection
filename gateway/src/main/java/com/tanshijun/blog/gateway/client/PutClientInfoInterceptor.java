package com.tanshijun.blog.gateway.client;

import com.tanshijun.blog.common.dto.ClientInfoDTO;
import com.tanshijun.blog.common.exception.ResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tanshijun-pc on 2017/10/31.
 */
public class PutClientInfoInterceptor extends HandlerInterceptorAdapter {


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
            ClientInfoDTO clientInfoDTO = clientService.queryClientInfo(request);
            LocalClientInfo.set(clientInfoDTO);
        }catch(Exception e){
            throw new ResponseException("000003","获取用户信息出错");
        }
        return super.preHandle(request, response, handler);
    }
}
