package com.blog.admin.service;

import com.alibaba.fastjson.JSON;
import com.blog.admin.bean.PicUploadResult;

import com.blog.common.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuhb on 2017/2/8.
 */
@Service
public class PicUploadService {

    @Autowired
    private ApiService apiService;

    @Value("${JBLOG_REST_URL}")
    private String JBLOG_REST_URL;

    public String upload(MultipartFile uploadFile) {
            try{
                String url = JBLOG_REST_URL + "/pic/upload";
                Map<String,String> params = new HashMap<String, String>();
                String jsonData = this.apiService.doUploadFile(url,uploadFile);
                // 封装Result对象，并且将文件的byte数组放置到result对象中
                return jsonData;
            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

}
