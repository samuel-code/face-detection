package com.tanshijun.blog.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by tanshijun-pc on 2017/10/9.
 */
public class TokenUtils {

    public static String findToken(HttpServletRequest request){
        Cookie[] cookieArray = request.getCookies();
        if(cookieArray != null){
            for(Cookie item : cookieArray){
                if("token".equals(item.getName())){
                    return item.getValue();
                }
            }
        }
        String token = request.getHeader("token");
        if(token != null && !"".equals(token.trim())){
            return token;
        }
        return request.getParameter("token");
    }
}
