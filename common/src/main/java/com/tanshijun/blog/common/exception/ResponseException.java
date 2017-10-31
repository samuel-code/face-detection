package com.tanshijun.blog.common.exception;

/**
 * Created by tanshijun-pc on 2017/10/30.
 */
public class ResponseException extends RuntimeException {

    private String responseCode;
    private String responseMsg;

    public ResponseException(String responseCode, String responseMsg){
        super(responseMsg);
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }


}
