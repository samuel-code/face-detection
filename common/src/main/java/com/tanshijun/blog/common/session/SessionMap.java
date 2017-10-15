package com.tanshijun.blog.common.session;

/**
 * 用来存储数据
 * Created by tanshijun-pc on 2017/10/11.
 */
public interface SessionMap {

    void remove(String key);

    Object get(String key);

    void set(String key, Object value);
}
