package com.tanshijun.blog.gateway.repository.mongo;

import com.tanshijun.blog.gateway.model.OperationRecordModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by tanshijun-pc on 2017/9/28.
 */
public interface MongoOperationRecordRepository extends MongoRepository<OperationRecordModel,String> {
}
