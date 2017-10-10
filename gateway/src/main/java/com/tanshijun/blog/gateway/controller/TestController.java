package com.tanshijun.blog.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tanshijun-pc on 2017/9/28.
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
