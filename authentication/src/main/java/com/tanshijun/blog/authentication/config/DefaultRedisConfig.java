package com.tanshijun.blog.authentication.config;

import com.tanshijun.blog.common.operation.redis.RedisOperation;
import com.tanshijun.blog.common.operation.redis.RedisOperationImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by tanshijun-pc on 2017/10/15.
 */
@Configuration
public class DefaultRedisConfig {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public RedisOperation<Object> redisOperations(RedisTemplate<String,Object> redisTemplate){
        RedisOperation<Object> redisOperations = new RedisOperationImpl(redisTemplate);
        return redisOperations;
    }
}
