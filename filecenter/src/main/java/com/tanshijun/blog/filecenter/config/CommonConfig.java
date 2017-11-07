package com.tanshijun.blog.filecenter.config;

import com.tanshijun.blog.common.client.UClientService;
import com.tanshijun.blog.common.client.UClientServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tanshijun-pc on 2017/11/1.
 */
@Configuration
public class CommonConfig {

    @Bean
    public UClientService getUClientService(){
        return new UClientServiceImpl();
    }
}
