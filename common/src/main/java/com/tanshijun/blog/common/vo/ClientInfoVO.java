package com.tanshijun.blog.common.vo;

/**
 * Created by tanshijun-pc on 2017/10/9.
 */
public class ClientInfoVO {

    private String userName;
    private String age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ClientInfoVO{" + "userName='" + userName + '\'' + ", age='" + age + '\'' + '}';
    }
}
