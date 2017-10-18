package com.tanshijun.blog.gateway.config;

import com.tanshijun.blog.common.operation.redis.RedisOperation;
import com.tanshijun.blog.common.operation.redis.RedisOperationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by tanshijun-pc on 2017/10/17.
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //设置支持事物
        redisTemplate.setEnableTransactionSupport(true);
        return redisTemplate;
    }

    @Bean
    public RedisOperation<Object> redisOperations(RedisTemplate<String,Object> redisTemplate){
        RedisOperation<Object> redisOperations = new RedisOperationImpl(redisTemplate);
        return redisOperations;
    }
}
