package com.tanshijun.blog.gateway.client;

import com.tanshijun.blog.common.dto.ClientInfoDTO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tanshijun-pc on 2017/10/31.
 */
public interface UClientService {

    ClientInfoDTO queryClientInfo(HttpServletRequest request);
}
