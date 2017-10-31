package com.tanshijun.blog.filecenter.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by tanshijun-pc on 2017/10/30.
 */
public interface FileService {

    /**
     * 用于文件上传
     * @param file
     * @return
     */
    void uploadFile(MultipartFile file) throws Exception;
}
