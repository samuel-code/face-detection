package com.tanshijun.blog.common.dto;

/**
 * Created by tanshijun-pc on 2017/10/9.
 */
public class ClientInfoDTO {

    private String name;
    private String sex;
    private String telNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "ClientInfoDTO{" + "name='" + name + '\'' + ", sex='" + sex + '\'' + ", telNumber='" + telNumber + '\'' + '}';
    }
}
