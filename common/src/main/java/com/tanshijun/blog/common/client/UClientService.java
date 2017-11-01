package com.tanshijun.blog.common.client;

import com.tanshijun.blog.common.dto.ClientInfoDTO;
import com.tanshijun.blog.common.vo.ClientInfoVO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tanshijun-pc on 2017/10/31.
 */
public interface UClientService {

    ClientInfoVO queryClientInfo(HttpServletRequest request);
}
