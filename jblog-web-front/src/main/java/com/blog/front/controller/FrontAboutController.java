package com.blog.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by liuhb on 2017/2/9.
 */
@RequestMapping("about")
@Controller
public class FrontAboutController {
    @RequestMapping(method = RequestMethod.GET)
    public String doAbout(){
        return "about";
    }

}
