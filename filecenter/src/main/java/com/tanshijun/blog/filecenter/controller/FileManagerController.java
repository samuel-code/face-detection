package com.tanshijun.blog.filecenter.controller;

import com.tanshijun.blog.common.vo.ResponseInfoVO;
import com.tanshijun.blog.filecenter.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by tanshijun-pc on 2017/11/5.
 */
@RestController
@RequestMapping("/authen")
public class FileManagerController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseInfoVO upload(MultipartFile file) throws Exception{
        logger.info("enter upload............."+file.getContentType()+":"+file.getOriginalFilename());
        fileService.uploadFile(file);
        return ResponseInfoVO.success();
    }
}
