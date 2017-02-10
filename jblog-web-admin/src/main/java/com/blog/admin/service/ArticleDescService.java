package com.blog.admin.service;

import com.alibaba.fastjson.JSON;
import com.blog.common.service.ApiService;
import com.blog.common.utils.StringUtils;
import com.blog.pojo.ArticleDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuhb on 2017/2/8.
 */
@Service
public class ArticleDescService{

    @Autowired
    private ApiService apiService;
    @Value("${JBLOG_REST_URL}")
    private String JBLOG_REST_URL;

    public ArticleDesc queryById(Long articleId) {
        try {
            String url = JBLOG_REST_URL + "/article/desc/"+articleId;
            String jsonData = this.apiService.doGet(url);
            if (StringUtils.isEmpty(jsonData))
                return null;
            return JSON.parseObject(jsonData,ArticleDesc.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
