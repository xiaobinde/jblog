package com.blog.front.service;

import com.alibaba.fastjson.JSON;
import com.blog.common.bean.EasyUIResult;
import com.blog.common.service.ApiService;
import com.blog.common.service.RedisService;
import com.blog.common.utils.StringUtils;
import com.blog.pojo.Article;
import com.blog.pojo.ArticleDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuhb on 2017/2/9.
 */
@Service
public class FrontArticleService {
    @Autowired
    private ApiService apiService;
    @Autowired
    private RedisService redisService;

    @Value("${JBLOG_FRONT_URL}")
    private String JBLOG_FRONT_URL;

    public static final String REDIS_KEY = "JBLOG_WEB_ARTICLE_DETAIL_";

    public List<Article> quaryArticleList(Integer page, Integer rows) {
        try {
            String url = JBLOG_FRONT_URL + "/article";
            Map<String,String> params = new HashMap<String, String>();
            params.put("page",String.valueOf(page));
            params.put("rows",String.valueOf(rows));
            String jsonData = this.apiService.doGet(url,params);
            if (StringUtils.isEmpty(jsonData)) {
                return null;
            }
            List<Article>list = JSON.parseArray(jsonData,Article.class);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Article queryItemById(Long articleId) {
//        String key = REDIS_KEY + articleId;
//        try {
//            String cacheData = this.redisService.get(key);
//            if (StringUtils.isNotEmpty(cacheData)) {
//                return JSON.parseObject(cacheData,Article.class);
//            }
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }

            try {
                String url = JBLOG_FRONT_URL + "/article/"+articleId;
                String jsonData = this.apiService.doGet(url);
                if (StringUtils.isEmpty(jsonData)) {
                    return null;
                }
                Article article = JSON.parseObject(jsonData,Article.class);
                return article;
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
    }

    public ArticleDesc queryItemDescByItemId(Long articleId) {
            try {
                String url = JBLOG_FRONT_URL + "/article/desc/" + articleId;
                String jsonData = this.apiService.doGet(url);
                if (StringUtils.isEmpty(jsonData)) {
                    return null;
                }
                return JSON.parseObject(jsonData, ArticleDesc.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
    }
}
