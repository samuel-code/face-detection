package com.tanshijun.blog.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by tanshijun-pc on 2017/9/28.
 */
@EnableDiscoveryClient
@SpringCloudApplication
public class AuthenticationApplication {

    public static void main(String[] args){
        SpringApplication.run(AuthenticationApplication.class,args);
    }
}
