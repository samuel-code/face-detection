package com.tanshijun.blog.common.session;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by tanshijun-pc on 2017/10/15.
 */
public class DistriServiceImpl implements DistriService {

    private static final String SESSION_KEY = "session_key";
    @Autowired
    private SessionMap sessionMap;
    @Override
    public HttpSession createHttpSession(HttpServletRequest request, HttpServletResponse response) {

        DistriHttpSession distriHttpSession = (DistriHttpSession) request.getAttribute(SESSION_KEY);
        if(distriHttpSession != null){
            return distriHttpSession;
        }
        distriHttpSession = new DistriHttpSession(sessionMap,request);
        request.setAttribute(SESSION_KEY,distriHttpSession);
        return distriHttpSession;
    }

}
