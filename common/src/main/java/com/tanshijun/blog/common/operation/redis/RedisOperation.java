package com.tanshijun.blog.common.operation.redis;

import org.springframework.data.redis.core.RedisCallback;

import java.util.concurrent.TimeUnit;

/**
 * Created by tanshijun-pc on 2017/10/16.
 */
public interface RedisOperation<T> {

    /**
     * map 操作
     * @param key
     * @param field
     * @param value
     */
    void hset(String key, String field, T value);

    /**
     *
     * @param key
     * @param field
     * @param value
     * @param timeUnit
     * @param expire 过期时间
     */
    void hset(String key, String field, T value, TimeUnit timeUnit, long expire );
    /**
     * map del操作
     * @param key
     * @param fields
     */
    void hdel(String key, String...fields);

    /**
     * map get操作
     * @param key
     * @param field
     * @return
     */
    T hget(String key, String field);

    /**
     * 设置key的过期时间
     * @param timeUnit
     * @param expire
     */
    void expire(String key, TimeUnit timeUnit, long expire);

    /**
     * 是否存在key
     * @param key
     * @return
     */
    boolean exists(String key);

    long incr(String key);

    <V> V exec(RedisCallback<V> redisCallback);
}
