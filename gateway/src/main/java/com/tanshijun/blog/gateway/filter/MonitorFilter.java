package com.tanshijun.blog.gateway.filter;

import com.tanshijun.blog.gateway.common.utils.IpUtils;
import com.tanshijun.blog.gateway.model.OperationRecordModel;
import com.tanshijun.blog.gateway.service.SaveOperationRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by tanshijun-pc on 2017/10/7.
 */
@WebFilter(filterName="myfilter",urlPatterns="/*")
public class MonitorFilter implements Filter {

    private SaveOperationRecordService service;

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init MonitorFilter");
        ServletContext servletContext = filterConfig.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        service = (SaveOperationRecordService)webApplicationContext.getBean("mongoSaveOrServiceImpl");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest)servletRequest;
        String requestPath = request.getRequestURI();
        logger.info("start {} ......",requestPath);
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long endTime = System.currentTimeMillis();
        long expendTime = endTime - startTime;
        logger.info("end {} [{}]",requestPath,expendTime);
        OperationRecordModel model = new OperationRecordModel(IpUtils.getIpAddress(request),expendTime,requestPath,request.getParameter("channel"));
        service.save(model);
    }

    @Override
    public void destroy() {
        service = null;
    }
}
