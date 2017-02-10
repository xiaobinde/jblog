package com.blog.front.service;

import com.alibaba.fastjson.JSON;
import com.blog.common.service.ApiService;
import com.blog.common.utils.StringUtils;
import com.blog.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuhb on 2017/2/8.
 */
@Service
public class IndexService {

    @Autowired
    private ApiService apiService;
    @Value("${JBLOG_FRONT_URL}")
    private String JBLOG_FRONT_URL;

    public List<Article> quaryArticleList(Integer page, Integer rows) {
        try {
            String url = JBLOG_FRONT_URL + "/index";
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

}
