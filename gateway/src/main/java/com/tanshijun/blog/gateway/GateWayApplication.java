package com.tanshijun.blog.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tanshijun-pc on 2017/9/28.
 */
@SpringCloudApplication
@EnableZuulProxy
@EnableDiscoveryClient
@ServletComponentScan
public class GateWayApplication {

    public static void main(String[] args){
        SpringApplication.run(GateWayApplication.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
