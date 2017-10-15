package com.tanshijun.blog.common.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

/**
 * Created by tanshijun-pc on 2017/10/11.
 */
public class DistriHttpServletRequestWapper extends HttpServletRequestWrapper {

    private DistriService distriService;

    private HttpServletRequest httpServletRequest;

    public DistriHttpServletRequestWapper(HttpServletRequest request,DistriService distriService) {
        super(request);
        this.distriService = distriService;
    }

    @Override
    public HttpSession getSession() {
        return getSession(true);
    }

    @Override
    public HttpSession getSession(boolean create) {
        return distriService.createHttpSession();
    }
}
