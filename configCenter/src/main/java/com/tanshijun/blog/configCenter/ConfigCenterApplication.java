package com.tanshijun.blog.configCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by tanshijun-pc on 2017/11/7.
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigCenterApplication {

    public static void main(String[] args){
        SpringApplication.run(ConfigCenterApplication.class,args);
    }
}
