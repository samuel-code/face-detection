package com.tanshijun.blog.filecenter.service.impl;

import com.tanshijun.blog.common.client.LocalClientInfo;
import com.tanshijun.blog.common.exception.ResponseException;
import com.tanshijun.blog.common.vo.ClientInfoVO;
import com.tanshijun.blog.filecenter.constant.FileCenterVOConstant;
import com.tanshijun.blog.filecenter.manager.FileManager;
import com.tanshijun.blog.filecenter.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tanshijun-pc on 2017/10/30.
 */
@Service
public class FileServiceImpl implements FileService{

    @Autowired
    private FileManager fileManager;

    @Override
    public void uploadFile(MultipartFile file) throws Exception{
        Map<String,Object> metaData = new HashMap<String,Object>();
        ClientInfoVO clientInfoVO = LocalClientInfo.get();
        metaData.put("author",clientInfoVO.getUserName());
        metaData.put("downloadAmount",0);
        if(!fileManager.upload(file.getInputStream(),file.getOriginalFilename(),file.getContentType(),metaData)){
            throw new ResponseException(FileCenterVOConstant.FILE_UPLOAD_FAIL_CODE,FileCenterVOConstant.FILE_UPLOAD_FAIL_MSG);
        }
    }
}
