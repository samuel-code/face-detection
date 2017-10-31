package com.tanshijun.blog.filecenter.manager;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by tanshijun-pc on 2017/10/30.
 */
public interface FileManager {

    /**
     * 用户文件上传
     * @param inputStream 文件
     * @param contentType 文件类型
     * @param metaData 描述文件的元数据
     * @return
     */
    boolean upload(InputStream inputStream,String fileName, String contentType, Map<String,Object> metaData);
}
