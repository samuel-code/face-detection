package com.tanshijun.blog.gateway.config;

import com.tanshijun.blog.gateway.interceptor.MonitorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by tanshijun-pc on 2017/9/28.
 */
//@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private MonitorInterceptor monitorInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir = registry.addInterceptor(monitorInterceptor);
        ir.addPathPatterns("/**");
    }
}
