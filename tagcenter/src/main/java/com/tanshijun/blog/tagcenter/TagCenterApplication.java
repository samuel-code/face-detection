package com.tanshijun.blog.tagcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by tanshijun-pc on 2017/10/23.
 */
@EnableDiscoveryClient
@SpringCloudApplication
public class TagCenterApplication {

    public static void main(String[] args){
        SpringApplication.run(TagCenterApplication.class,args);
    }
}
