package com.tanshijun.blog.common.constant;

/**
 * 认证状态
 * Created by tanshijun-pc on 2017/10/9.
 */
public enum AuthenEnum {

    NOTLOGIN("AU0001",1000,"未登录"),
    AUHENSUCCESS("AU0000",0000,"成功"),
    INVALID("AU0002",1001,"无效token"),
    ACCESSLIMIT("AU0002",1002,"访问太频繁,稍后访问");
    private String responseCode;

    private int headCode;

    private String desc;

    AuthenEnum(String responseCode , int headCode, String desc){
        this.responseCode = responseCode;
        this.headCode = headCode;
        this.desc = desc;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public int getHeadCode() {
        return headCode;
    }

    public void setHeadCode(int headCode) {
        this.headCode = headCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public static AuthenEnum find(String responseCode){
        if(NOTLOGIN.responseCode.equals(responseCode)){
            return NOTLOGIN;
        }

        if(INVALID.responseCode.equals(responseCode)){
            return INVALID;
        }

        return AUHENSUCCESS;
    }
}
