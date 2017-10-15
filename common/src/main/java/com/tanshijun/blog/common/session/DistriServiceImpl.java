package com.tanshijun.blog.common.session;

import javax.servlet.http.HttpSession;

/**
 * Created by tanshijun-pc on 2017/10/15.
 */
public class DistriServiceImpl implements DistriService {

    private DistriHttpSession distriHttpSession;
    @Override
    public HttpSession createHttpSession() {
        return null;
    }

    @Override
    public String sessionId() {
        return null;
    }
}
