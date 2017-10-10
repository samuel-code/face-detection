package com.tanshijun.blog.gateway.service.impl;

import com.tanshijun.blog.gateway.model.OperationRecordModel;
import com.tanshijun.blog.gateway.repository.mongo.MongoOperationRecordRepository;
import com.tanshijun.blog.gateway.service.SaveOperationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tanshijun-pc on 2017/9/28.
 */
@Service("mongoSaveOrServiceImpl")
public class MongoSaveOrServiceImpl implements SaveOperationRecordService {
   @Autowired
    private MongoOperationRecordRepository recordRepository;

    @Override
    public void save(OperationRecordModel model) {
        model = recordRepository.save(model);
        System.out.println("MongoSaveOrServiceImpl:"+model);
    }
}
