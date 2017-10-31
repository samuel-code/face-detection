package com.tanshijun.blog.gateway.client;

import com.tanshijun.blog.common.dto.ClientInfoDTO;
import com.tanshijun.blog.common.exception.ResponseException;
import com.tanshijun.blog.common.vo.ClientInfoVO;

/**
 * Created by tanshijun-pc on 2017/10/31.
 */
public class LocalClientInfo {

    private static ThreadLocal<ClientInfoDTO> clientInfoLocal = new ThreadLocal<>();

    public static void set(ClientInfoDTO clientInfoDTO){
        clientInfoLocal.set(clientInfoDTO);
    }

    public static ClientInfoDTO get(){
        ClientInfoDTO clientInfoDTO = clientInfoLocal.get();
        if(clientInfoDTO == null){
            throw new ResponseException("000002","clientInfo is null");
        }
        return clientInfoDTO;
    }

    public static void remove(){
        clientInfoLocal.remove();
    }
}
