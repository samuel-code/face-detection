package com.tanshijun.blog.tagcenter.repository.mongo;

import com.tanshijun.blog.tagcenter.model.TagModel;
import com.tanshijun.blog.tagcenter.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by tanshijun-pc on 2017/10/23.
 */
@Repository("mongoTagRepository")
public class MongoTagRepository implements TagRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void add(TagModel tagModel) {
        mongoTemplate.save(tagModel);
    }

    @Override
    public TagModel findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("tagName").is(name));
        return  mongoTemplate.findOne(query,TagModel.class);
    }
}
