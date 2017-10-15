package com.tanshijun.blog.common.session;

import javax.servlet.http.HttpSession;

/**
 * Created by tanshijun-pc on 2017/10/15.
 */
public interface DistriService {

    HttpSession createHttpSession();

    String sessionId();
}
