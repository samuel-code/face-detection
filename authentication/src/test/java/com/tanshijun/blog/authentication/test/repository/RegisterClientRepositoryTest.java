package com.tanshijun.blog.authentication.test.repository;

import com.tanshijun.blog.authentication.model.RegisterClientModel;
import com.tanshijun.blog.authentication.repository.RegisterClientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tanshijun-pc on 2017/10/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterClientRepositoryTest {

    @Autowired
    private RegisterClientRepository registerClientRepository;

    @Test
    public void insert(){
        RegisterClientModel model = new RegisterClientModel();
        model.setLogoUrl("http://www.baidu.com");
        model.setCompany("北京创业公司");
        model.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        model.setLoginName("15111111111");
        model.setPassword("111111");
        model.setPosition("开发工程师");
        model.setUserName("小黄");
        registerClientRepository.save(model);
    }
}
