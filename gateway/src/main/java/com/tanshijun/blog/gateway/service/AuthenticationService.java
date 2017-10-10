package com.tanshijun.blog.gateway.service;

import com.tanshijun.blog.common.constant.AuthenEnum;
import com.tanshijun.blog.common.dto.ClientInfoDTO;

import javax.servlet.http.HttpServletRequest;

/**
 * 认证服务
 * Created by tanshijun-pc on 2017/10/9.
 */
public interface AuthenticationService {

    /**
     * 调用认证中心进行认证，如果
     * @param request
     * @return
     */
    AuthenEnum authen(HttpServletRequest request);
}
