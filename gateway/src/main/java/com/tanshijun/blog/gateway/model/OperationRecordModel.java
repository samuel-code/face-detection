package com.tanshijun.blog.gateway.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by tanshijun-pc on 2017/9/28.
 */
@Document(collection = "operationRecord")
public class OperationRecordModel implements Serializable{

    @Id
    private String id;

    private String ip;

    private long expendTime;

    private String requestUrl;

    private String channel;

    public OperationRecordModel() {
    }

    public OperationRecordModel(String ip, long expendTime, String requestUrl, String channel) {
        this.ip = ip;
        this.expendTime = expendTime;
        this.requestUrl = requestUrl;
        this.channel = channel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getExpendTime() {
        return expendTime;
    }

    public void setExpendTime(long expendTime) {
        this.expendTime = expendTime;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "OperationRecordModel{" + "id='" + id + '\'' + ", ip='" + ip + '\'' + ", expendTime=" + expendTime + ", requestUrl='" + requestUrl + '\'' + ", channel='" + channel + '\'' + '}';
    }
}
