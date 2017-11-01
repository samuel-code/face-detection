package com.tanshijun.blog.common.client;

import com.tanshijun.blog.common.dto.ClientInfoDTO;
import com.tanshijun.blog.common.utils.TokenUtils;
import com.tanshijun.blog.common.vo.ClientInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tanshijun-pc on 2017/11/1.
 */
public class UClientServiceImpl implements UClientService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${qry.client.serviceId}")
    private String clientServiceId;
    @Override
    public ClientInfoVO queryClientInfo(HttpServletRequest request) {
        String token = TokenUtils.findToken(request);
        logger.info("queryClientInfo token : " + token);
        ResponseEntity<ClientInfoVO> responseEntity = restTemplate.getForEntity("http://"+clientServiceId+"/authen/clientInfo?token={token}", ClientInfoVO.class,token);
        ClientInfoVO clientInfoDTO = responseEntity.getBody();
        logger.info("queryClientInfo result: " + clientInfoDTO);
        return clientInfoDTO;
    }
}
