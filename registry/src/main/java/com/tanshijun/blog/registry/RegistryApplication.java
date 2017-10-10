package com.tanshijun.blog.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by tanshijun-pc on 2017/9/29.
 */
@EnableEurekaServer
@SpringBootApplication
public class RegistryApplication {

    public static void main(String[] args){
        new SpringApplication(RegistryApplication.class).run(args);
    }
}
