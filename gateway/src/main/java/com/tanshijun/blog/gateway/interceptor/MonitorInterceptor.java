package com.tanshijun.blog.gateway.interceptor;

import com.tanshijun.blog.gateway.common.utils.IpUtils;
import com.tanshijun.blog.gateway.model.OperationRecordModel;
import com.tanshijun.blog.gateway.service.SaveOperationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import sun.net.util.IPAddressUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tanshijun-pc on 2017/9/28.
 */
@Component
public class MonitorInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SaveOperationRecordService service;
    private final static ThreadLocal<Long> timeThreadLocal = new ThreadLocal<Long>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MonitorInterceptor:preHandle");
        timeThreadLocal.set(System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        try{
            System.out.println("MonitorInterceptor:afterCompletion");
            long endTime = System.currentTimeMillis();
            Long startTime = timeThreadLocal.get();
            long expendTime = endTime - startTime;
            OperationRecordModel model = new OperationRecordModel(IpUtils.getIpAddress(request),expendTime,request.getRequestURI(),request.getParameter("channel"));
            service.save(model);
        }finally {
            timeThreadLocal.remove();
        }
    }
}
