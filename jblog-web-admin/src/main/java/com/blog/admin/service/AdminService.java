package com.blog.admin.service;

import com.alibaba.fastjson.JSON;
import com.blog.common.httpclient.HttpResult;
import com.blog.common.service.ApiService;
import com.blog.common.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuhb on 2017/1/11.
 */

@Service
public class AdminService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private ApiService apiService;

    @Value("${JBLOG_REST_URL}")
    private String JBLOG_REST_URL;

    public String login(String username, String password) {
        try {
            String url = JBLOG_REST_URL + "/user/login";
            Map<String,String> params = new HashMap<String, String>();
            params.put("username",username);
            params.put("password",password);
            HttpResult result = this.apiService.doPost(url,params);
            if (result.getCode() == HttpStatus.OK.value()) {
                //登录成功
                String token = result.getData();
                return token;
            } else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


}
