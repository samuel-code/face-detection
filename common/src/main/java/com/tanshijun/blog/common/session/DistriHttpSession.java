package com.tanshijun.blog.common.session;

import com.tanshijun.blog.common.utils.TokenUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;

/**
 * 分布式session
 * Created by tanshijun-pc on 2017/10/11.
 */
public class DistriHttpSession  implements HttpSession{

    private SessionMap sessionMap;

    private HttpServletRequest httpServletRequest;


    private long createTime;

    public DistriHttpSession(SessionMap sessionMap, HttpServletRequest httpServletRequest){
        this.createTime = System.currentTimeMillis();
        this.sessionMap = sessionMap;
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public long getCreationTime() {
        return createTime;
    }

    @Override
    public String getId() {
        return TokenUtils.findToken(httpServletRequest);
    }

    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public void setMaxInactiveInterval(int i) {

    }

    @Override
    public int getMaxInactiveInterval() {
        return 0;
    }

    @Override
    public HttpSessionContext getSessionContext() {
        return null;
    }

    @Override
    public Object getAttribute(String s) {
        return null;
    }

    @Override
    public Object getValue(String s) {
        return null;
    }

    @Override
    public Enumeration getAttributeNames() {
        return null;
    }

    @Override
    public String[] getValueNames() {
        return new String[0];
    }

    @Override
    public void setAttribute(String s, Object o) {

    }

    @Override
    public void putValue(String s, Object o) {

    }

    @Override
    public void removeAttribute(String s) {

    }

    @Override
    public void removeValue(String s) {

    }

    @Override
    public void invalidate() {

    }

    @Override
    public boolean isNew() {
        return false;
    }
}
