package com.tanshijun.blog.common.session;

import com.tanshijun.blog.common.operation.redis.RedisOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by tanshijun-pc on 2017/10/13.
 */
public class RedisSessionMap implements SessionMap {
    @Autowired
    private RedisOperation<Object> redisOperation;

    @Override
    public void remove(String sessionId, String key) {
        redisOperation.hdel(sessionId,key);
    }

    @Override
    public Object get(String sessionId, String key) {
        return redisOperation.hget(sessionId,key);
    }

    @Override
    public void set(String sessionId, String key, Object value) {
        redisOperation.hset(sessionId,key,value);
    }
}
