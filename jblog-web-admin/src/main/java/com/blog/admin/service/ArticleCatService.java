package com.blog.admin.service;

import com.alibaba.fastjson.JSON;
import com.blog.common.httpclient.HttpResult;
import com.blog.common.service.ApiService;
import com.blog.common.service.RedisService;
import com.blog.common.utils.StringUtils;
import com.blog.pojo.ArticleCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuhaibin on 06/02/2017.
 */
@Service
public class ArticleCatService{

    @Autowired
    private RedisService redisService;
    @Autowired
    private ApiService apiService;

    @Value("${JBLOG_REST_URL}")
    private String JBLOG_REST_URL;


    public List<ArticleCat> queryListByParentId(long parentId) {
        try {
            String url = JBLOG_REST_URL + "/article/cat";
            Map<String,String> params = new HashMap<String, String>();
            params.put("id",String.valueOf(parentId));
            String jsonData = this.apiService.doGet(url,params);
            if (StringUtils.isEmpty(jsonData)) {
                return null;
            }
            return JSON.parseArray(jsonData,ArticleCat.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
