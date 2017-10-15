package com.tanshijun.blog.authentication.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户注册实体类
 * Created by tanshijun-pc on 2017/10/10.
 */
@Entity
@Table(name = "JJ_REGISTER_CLIENT_TAB")
public class RegisterClientModel implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    //用户名
    @Column(name = "USERNAME")
    private String userName;
    //登录名--->手机号
    @Column(name = "LOGINNAME")
    private String loginName;
    //登录密码
    @Column(name = "PASSWORD")
    private String password;
    //图像地址
    @Column(name="LOGOURL")
    private String logoUrl;
    //简介
    @Column(name = "SUMMARY")
    private String summary;
    //公司
    @Column(name = "COMPANY")
    private String company;
    //职位
    @Column(name = "POSITION")
    private String position;
    //创建时间
    @Column(name = "CREATETIME")
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
