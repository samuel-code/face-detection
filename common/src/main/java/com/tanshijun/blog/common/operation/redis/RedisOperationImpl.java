package com.tanshijun.blog.common.operation.redis;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.Client;
import redis.clients.jedis.Transaction;

import java.util.concurrent.TimeUnit;

/**
 * Created by tanshijun-pc on 2017/10/16.
 */
public class RedisOperationImpl<T> implements RedisOperation<T> {

    private RedisTemplate<String,T> redisTemplate;

    public RedisOperationImpl(){}

    public RedisOperationImpl(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void hset(String key, String field, T value) {
        redisTemplate.boundHashOps(key).put(field,value);
    }

    @Override
    public void hset(String key, String field, T value, TimeUnit timeUnit, long expire) {
        BoundHashOperations boundHashOperations = redisTemplate.boundHashOps(key);
        boundHashOperations.put(field,value);
        boundHashOperations.expire(expire,timeUnit);

    }

    @Override
    public void hdel(String key, String... fields) {
        redisTemplate.boundHashOps(key).delete(fields);
    }

    @Override
    public T hget(String key, String field) {
        return (T)redisTemplate.boundHashOps(key).get(field);
    }

    @Override
    public void expire(String key,TimeUnit timeUnit, long expire) {

        redisTemplate.expire(key,expire,timeUnit);
    }

    @Override
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public long incr(final String key) {

        final byte[] byteKey = redisTemplate.getStringSerializer().serialize(key);
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.incr(byteKey);
            }
        });
    }

    @Override
    public <V> V exec(RedisCallback<V> redisCallback) {
        return redisTemplate.execute(redisCallback);
    }


}
