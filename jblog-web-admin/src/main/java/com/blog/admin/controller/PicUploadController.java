package com.blog.admin.controller;

import com.blog.admin.service.PicUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by liuhb on 2017/2/8.
 */
@Controller
@RequestMapping("admin/pic")
public class PicUploadController {

    @Autowired
    private PicUploadService picUploadService;

    @RequestMapping(value = "/upload",method = RequestMethod.POST,produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String upload(@RequestParam("uploadFile") MultipartFile uploadFile)
            throws Exception{
         return this.picUploadService.upload(uploadFile);
    }



}
