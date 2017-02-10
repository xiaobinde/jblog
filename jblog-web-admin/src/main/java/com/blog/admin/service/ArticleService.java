package com.blog.admin.service;

import com.alibaba.fastjson.JSON;
import com.blog.common.bean.EasyUIResult;
import com.blog.common.httpclient.HttpResult;
import com.blog.common.service.ApiService;
import com.blog.common.utils.StringUtils;

import com.blog.pojo.Article;
import com.blog.pojo.ArticleDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuhb on 2017/2/7.
 */
@Service
public class ArticleService {

    @Autowired
    private ApiService apiService;
    @Value("${JBLOG_REST_URL}")
    private String JBLOG_REST_URL;

    public void saveItem(Article article, String desc) {
        try {
            String url = JBLOG_REST_URL + "/article";
            Map<String,String> params = new HashMap<String, String>();
            params.put("title",article.getTitle());
            params.put("sellPoint",article.getSellPoint());
            params.put("image",article.getImage());
            params.put("cid", String.valueOf(article.getCid()));
            params.put("desc",desc);
            this.apiService.doPost(url,params);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public EasyUIResult queryPageList(Integer page, Integer rows) {
        try {
            String url = JBLOG_REST_URL + "/article";
            Map<String,String> params = new HashMap<String, String>();
            params.put("page",String.valueOf(page));
            params.put("rows",String.valueOf(rows));
            String jsonData = this.apiService.doGet(url,params);
            if (StringUtils.isEmpty(jsonData)) {
                return null;
            }
            EasyUIResult easyUIResult = JSON.parseObject(jsonData,EasyUIResult.class);
            return easyUIResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateArticle(Article article, String desc) {
            try {
                String url = JBLOG_REST_URL + "/article";
                Map<String,String> params = new HashMap<String, String>();
                params.put("id",String.valueOf(article.getId()));
                params.put("title",article.getTitle());
                params.put("sellPoint",article.getSellPoint());
                params.put("image",article.getImage());
                params.put("cid", String.valueOf(article.getCid()));
                params.put("desc",desc);
                this.apiService.doPut(url,params);
            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
