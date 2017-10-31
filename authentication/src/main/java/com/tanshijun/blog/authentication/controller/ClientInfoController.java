package com.tanshijun.blog.authentication.controller;

import com.tanshijun.blog.common.constant.VOConstant;
import com.tanshijun.blog.common.vo.ClientInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tanshijun-pc on 2017/10/9.
 */
@RestController
@RequestMapping("/authen")
public class ClientInfoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/clientInfo")
    public ClientInfoVO findClientInfo(@RequestParam("token") String token){
        ClientInfoVO infoVO = new ClientInfoVO();
        infoVO.setAge("12");
        infoVO.setUserName("lisai");
        infoVO.setResponseCode(VOConstant.SUCCESS_CODE);
        return infoVO;
    }
}
