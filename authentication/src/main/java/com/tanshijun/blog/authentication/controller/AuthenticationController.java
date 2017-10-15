package com.tanshijun.blog.authentication.controller;

import com.tanshijun.blog.authentication.model.RegisterClientModel;
import com.tanshijun.blog.authentication.repository.RegisterClientRepository;
import com.tanshijun.blog.common.constant.AuthenEnum;
import com.tanshijun.blog.common.constant.VOConstant;
import com.tanshijun.blog.common.vo.BaseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tanshijun-pc on 2017/9/28.
 */
@RestController
public class AuthenticationController {
   private Logger logger = LoggerFactory.getLogger(getClass());

   @Autowired
   private RegisterClientRepository registerClientRepository;
   @GetMapping("/login")
   public BaseVO login(){
      BaseVO vo = new BaseVO();
      vo.setResponseCode(VOConstant.SUCCESS_CODE);
      vo.setResponseMsg(VOConstant.SUCCESS_MSG);
      RegisterClientModel model = new RegisterClientModel();
      model.setLogoUrl("http://www.baidu.com");
      model.setCompany("北京创业公司");
      model.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
      model.setLoginName("15111111111");
      model.setPassword("111111");
      model.setPosition("开发工程师");
      model.setUserName("小黄");
      registerClientRepository.save(model);
      return vo;
   }

   @GetMapping("/authen")
   public BaseVO authentication(String token){
      logger.info("enter authen {}",token);
      BaseVO vo = new BaseVO();
      if(StringUtils.isEmpty(token)){
         vo.setResponseCode(AuthenEnum.NOTLOGIN.getResponseCode());
         vo.setResponseMsg(AuthenEnum.NOTLOGIN.getDesc());
      }else if("aaaaaa".equals(token)){
         vo.setResponseCode(AuthenEnum.INVALID.getResponseCode());
         vo.setResponseMsg(AuthenEnum.INVALID.getDesc());
      }else{
         vo.setResponseCode(VOConstant.SUCCESS_CODE);
         vo.setResponseMsg(VOConstant.SUCCESS_MSG);
      }
      return vo;
   }
}
