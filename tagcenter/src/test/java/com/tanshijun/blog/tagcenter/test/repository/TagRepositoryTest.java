package com.tanshijun.blog.tagcenter.test.repository;

import com.tanshijun.blog.tagcenter.model.TagModel;
import com.tanshijun.blog.tagcenter.repository.TagRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by tanshijun-pc on 2017/10/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TagRepositoryTest {

    @Resource(name = "mongoTagRepository")
    private TagRepository tagRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testAdd(){
        TagModel model = new TagModel();
        model.setTagName("java");
        model.setCreateDate(new Date());
        tagRepository.add(model);
    }

    @Test
    public void find(){
        logger.info("tagRepositorymodel result:"+tagRepository.findByName("java"));
    }
}
