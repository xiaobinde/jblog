package com.blog.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liuhb on 2017/1/13.
 */

@RequestMapping("admin/comment")
public class CommentController {

    public String index(){
        return "index";
    }
}
