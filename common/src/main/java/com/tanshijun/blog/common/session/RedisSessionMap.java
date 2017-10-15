package com.tanshijun.blog.common.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by tanshijun-pc on 2017/10/13.
 */
public class RedisSessionMap implements SessionMap {
    private RedisTemplate<String,Object> redisTemplate;
    private String sessionId;

    public RedisSessionMap(String sessionId){
        this.sessionId = sessionId;
    }
    @Override
    public void remove(String key) {
        redisTemplate.boundHashOps(sessionId).delete(key);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.boundHashOps(sessionId).get(key);
    }

    @Override
    public void set(String key, Object value) {
        redisTemplate.boundHashOps(sessionId).put(key,value);
    }
}
