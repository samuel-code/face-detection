package com.tanshijun.blog.filecenter;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tanshijun-pc on 2017/10/30.
 */
@EnableDiscoveryClient
@SpringCloudApplication
public class FileCenterApplication {

    public static void main(String[] args){
        SpringApplication.run(FileCenterApplication.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
