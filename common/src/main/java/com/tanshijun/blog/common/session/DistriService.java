package com.tanshijun.blog.common.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by tanshijun-pc on 2017/10/15.
 */
public interface DistriService {

    HttpSession createHttpSession(HttpServletRequest request, HttpServletResponse response);

}
