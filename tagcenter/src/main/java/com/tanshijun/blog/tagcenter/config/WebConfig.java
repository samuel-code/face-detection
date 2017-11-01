package com.tanshijun.blog.tagcenter.config;

import com.tanshijun.blog.common.client.PutClientInfoInterceptor;
import com.tanshijun.blog.common.client.UClientService;
import com.tanshijun.blog.common.config.DefaultMvcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * Created by tanshijun-pc on 2017/11/1.
 */
@Configuration
public class WebConfig extends DefaultMvcConfig {

    @Autowired
    private UClientService uClientService;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir = registry.addInterceptor(new PutClientInfoInterceptor(uClientService));
        ir.addPathPatterns("/authen/**");
    }
}
