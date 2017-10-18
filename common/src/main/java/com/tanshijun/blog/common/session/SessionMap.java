package com.tanshijun.blog.common.session;

/**
 * 用来存储数据
 * Created by tanshijun-pc on 2017/10/11.
 */
public interface SessionMap {

    void remove(String sessionId, String key);

    Object get(String sessionId,String key);

    void set(String sessionId,String key, Object value);
}
