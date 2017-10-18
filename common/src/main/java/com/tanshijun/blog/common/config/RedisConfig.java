package com.tanshijun.blog.common.config;

import com.tanshijun.blog.common.operation.redis.RedisOperation;
import com.tanshijun.blog.common.operation.redis.RedisOperationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by tanshijun-pc on 2017/10/17.
 */
public class RedisConfig {

    @Bean
    public RedisOperation redisOperation(RedisTemplate redisTemplate){
        RedisOperationImpl redisOperation = new RedisOperationImpl(redisTemplate);
        return redisOperation;
    }
}
