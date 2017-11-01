package com.tanshijun.blog.common.client;

import com.tanshijun.blog.common.dto.ClientInfoDTO;
import com.tanshijun.blog.common.exception.ResponseException;
import com.tanshijun.blog.common.vo.ClientInfoVO;

/**
 * Created by tanshijun-pc on 2017/10/31.
 */
public class LocalClientInfo {

    private static ThreadLocal<ClientInfoVO> clientInfoLocal = new ThreadLocal<ClientInfoVO>();

    public static void set(ClientInfoVO clientInfoDTO){
        clientInfoLocal.set(clientInfoDTO);
    }

    public static ClientInfoVO get(){
        ClientInfoVO clientInfoVo = clientInfoLocal.get();
        if(clientInfoVo == null){
            throw new ResponseException("000002","clientInfo is null");
        }
        return clientInfoVo;
    }

    public static void remove(){
        clientInfoLocal.remove();
    }
}
