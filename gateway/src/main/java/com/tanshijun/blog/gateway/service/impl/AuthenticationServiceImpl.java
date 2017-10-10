package com.tanshijun.blog.gateway.service.impl;

import com.tanshijun.blog.common.constant.AuthenEnum;
import com.tanshijun.blog.common.utils.TokenUtils;
import com.tanshijun.blog.common.vo.BaseVO;
import com.tanshijun.blog.gateway.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tanshijun-pc on 2017/10/9.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${zuul.routes.authen.serviceId}")
    private String authServiceId;

    @Override
    public AuthenEnum authen(HttpServletRequest request) {
        String token = TokenUtils.findToken(request);
        ResponseEntity<BaseVO> responseEntity = restTemplate.getForEntity("http://"+authServiceId+"/authen", BaseVO.class,token);
        BaseVO baseVo = responseEntity.getBody();
        return AuthenEnum.find(baseVo.getResponseCode());
    }
}
