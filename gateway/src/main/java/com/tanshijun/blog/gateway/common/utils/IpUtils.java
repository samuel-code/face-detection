package com.tanshijun.blog.gateway.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tanshijun-pc on 2017/9/28.
 */
public class IpUtils {

    public static String getIpAddress(HttpServletRequest request){
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
}
