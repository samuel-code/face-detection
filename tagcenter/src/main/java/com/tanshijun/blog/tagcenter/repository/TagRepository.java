package com.tanshijun.blog.tagcenter.repository;

import com.tanshijun.blog.tagcenter.model.TagModel;

/**
 * Created by tanshijun-pc on 2017/10/23.
 */
public interface TagRepository {

    void add(TagModel tagModel);

    TagModel findByName(String name);
}
