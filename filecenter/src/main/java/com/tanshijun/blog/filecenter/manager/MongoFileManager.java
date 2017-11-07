package com.tanshijun.blog.filecenter.manager;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * 基于mongoDB的gridFS的文件管理
 * Created by tanshijun-pc on 2017/10/30.
 */
@Component
public class MongoFileManager implements FileManager {
    private MongoTemplate mongoTemplate;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public MongoFileManager(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public boolean upload(InputStream inputStream, String fileName, String contentType, Map<String, Object> metaData) {

        return mongoTemplate.execute( (DB db) ->  {

            GridFS gridFS = new GridFS(db);
            try{
                GridFSInputFile inputFile = gridFS.createFile(inputStream);
                inputFile.setContentType(contentType);
                inputFile.setMetaData(new BasicDBObject(metaData));
                inputFile.setFilename(fileName);
                inputFile.save();
            }catch(Exception e){
                logger.error("upload file:"+fileName+" exception",e);
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        });
    }
}
