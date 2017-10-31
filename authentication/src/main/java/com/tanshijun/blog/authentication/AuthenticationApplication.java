package com.tanshijun.blog.authentication;

import com.tanshijun.blog.common.config.DefaultMvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by tanshijun-pc on 2017/9/28.
 */
@EnableDiscoveryClient
@SpringCloudApplication
@ImportAutoConfiguration(value = {DefaultMvcConfig.class})
public class AuthenticationApplication {

    public static void main(String[] args){
        SpringApplication.run(AuthenticationApplication.class,args);
    }
}
