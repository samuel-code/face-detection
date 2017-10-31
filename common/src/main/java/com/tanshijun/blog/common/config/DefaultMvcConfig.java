package com.tanshijun.blog.common.config;

import com.tanshijun.blog.common.resolver.ResponseExceptionResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by tanshijun-pc on 2017/10/30.
 */
public class DefaultMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new ResponseExceptionResolver());
    }
}
