package com.tanshijun.blog.gateway.service.impl;

import com.tanshijun.blog.common.constant.AuthenEnum;
import com.tanshijun.blog.common.dto.ClientInfoDTO;
import com.tanshijun.blog.common.utils.TokenUtils;
import com.tanshijun.blog.common.vo.ResponseInfoVO;
import com.tanshijun.blog.gateway.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${zuul.routes.authen.serviceId}")
    private String authServiceId;

    @Override
    public AuthenEnum authen(HttpServletRequest request) {
        String token = TokenUtils.findToken(request);
        logger.info("-------findtoken---------------"+token);
        ResponseEntity<ResponseInfoVO> responseEntity = restTemplate.getForEntity("http://"+authServiceId+"/authen?token={token}", ResponseInfoVO.class,token);
        ResponseInfoVO baseVo = responseEntity.getBody();
        return AuthenEnum.find(baseVo.getResponseCode());
    }

    @Override
    public ClientInfoDTO queryClient(HttpServletRequest request) {
        String token = TokenUtils.findToken(request);
        ResponseEntity<ClientInfoDTO> responseEntity = restTemplate.getForEntity("http://"+authServiceId+"/authen/clientInfo?token={token}", ClientInfoDTO.class,token);
        return responseEntity.getBody();
    }


}
