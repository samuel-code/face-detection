package com.tanshijun.blog.authentication.model;

import java.io.Serializable;

/**
 * 用户注册实体类
 * Created by tanshijun-pc on 2017/10/10.
 */
public class RegisterClientModel implements Serializable{

    private Long id;
    //用户名
    private String userName;
    //登录名--->手机号
    private String loginName;
    //登录密码
    private String password;
    //图像地址
    private String logoUrl;
    //简介
    private String summary;
    //公司
    private String company;
    //职位
    private String position;
    //创建时间
    private String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
