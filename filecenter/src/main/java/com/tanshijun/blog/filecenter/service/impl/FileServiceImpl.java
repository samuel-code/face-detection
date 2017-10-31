package com.tanshijun.blog.filecenter.service.impl;

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
        Map<String,Object> metaData = new HashMap<>();
        metaData.put("author","tanshijun");
        metaData.put("downloadAmount",0);
        if(fileManager.upload(file.getInputStream(),file.getName(),file.getContentType(),metaData)){

        }else{

        }
    }
}
