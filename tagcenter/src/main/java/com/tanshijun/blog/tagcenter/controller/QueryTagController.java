package com.tanshijun.blog.tagcenter.controller;

import com.tanshijun.blog.common.client.LocalClientInfo;
import com.tanshijun.blog.common.dto.ClientInfoDTO;
import com.tanshijun.blog.common.exception.ResponseException;
import com.tanshijun.blog.common.vo.ClientInfoVO;
import com.tanshijun.blog.tagcenter.vo.TagVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanshijun-pc on 2017/11/1.
 */
@RestController
@RequestMapping("/authen")
public class QueryTagController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/tag")
    public ArrayList<TagVO> queryTag(@RequestParam("flag") String flag){

        if("1".equals(flag)){
            throw new ResponseException("000111","非法请求");
        }
        ClientInfoVO clientInfoDTO = LocalClientInfo.get();
        logger.info("query tag: " + clientInfoDTO);
        ArrayList<TagVO> tagList = new ArrayList<TagVO>();
        TagVO tagVO = new TagVO();
        tagVO.setTagId("1");
        tagVO.setTagName("java");
        tagList.add(tagVO);

        tagVO = new TagVO();
        tagVO.setTagId("2");
        tagVO.setTagName("c++");
        tagList.add(tagVO);

        tagVO = new TagVO();
        tagVO.setTagId("3");
        tagVO.setTagName("c#");
        tagList.add(tagVO);

        return tagList;
    }
}
