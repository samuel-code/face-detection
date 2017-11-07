package com.tanshijun.blog.common.vo;

import com.tanshijun.blog.common.constant.VOConstant;

/**
 * Created by tanshijun-pc on 2017/9/29.
 */
public class ResponseInfoVO<T> {

    private String responseCode;

    private String responseMsg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private T data;


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


    public static <T> ResponseInfoVO success(T data){

        ResponseInfoVO responseInfoVO = new ResponseInfoVO();
        responseInfoVO.setResponseCode(VOConstant.SUCCESS_CODE);
        responseInfoVO.setResponseMsg(VOConstant.SUCCESS_MSG);
        if(data != null){
            responseInfoVO.setData(data);
        }
        return responseInfoVO;
    }

    public static ResponseInfoVO success(){
        return success(null);
    }
}
