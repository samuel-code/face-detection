package com.tanshijun.blog.tagcenter.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by tanshijun-pc on 2017/10/23.
 */
@Document(collection = "tag")
public class TagModel implements Serializable {

    @Id
    private String id;

    private String tagName;

    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "TagModel{" + "id='" + id + '\'' + ", tagName='" + tagName + '\'' + ", createDate=" + createDate + '}';
    }
}
