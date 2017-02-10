package com.blog.admin.controller;

import com.blog.admin.render.AjaxResult;
import com.blog.admin.service.AdminService;
import com.blog.common.utils.CookieUtils;
import com.blog.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by liuhaibin on 08/01/2017.
 */
@RequestMapping("admin")
@Controller
public class AdminController extends AdminBaseController {

    @Autowired
    private AdminService adminService;

    public static final String COOKIE_NAME = "BB_TOKEN";

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    @RequestMapping("login")
    public String dologin(){
        return "login";
    }

    @RequestMapping(value = "admin/login",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult login(String username, String password,String remember_me,
                            HttpServletRequest request, HttpServletResponse response){

        if (StringUtils.isEmpty(username,password)) {
            return renderAjaxResultForError("用户名或者密码不能为空！");
        }
        try {
            String token = this.adminService.login(username,password);
            if (null == token){
                return renderAjaxResultForError("登录失败");
            }
            //登录成功,记住我
            if (StringUtils.equals("on",remember_me))
                 CookieUtils.setCookie(request, response, COOKIE_NAME, token);
            else
                CookieUtils.deleteCookie(request,response,COOKIE_NAME);
        }catch (Exception e){
            e.printStackTrace();
            return renderAjaxResultForError("服务器异常!");
        }

        return  renderAjaxResultForSuccess("登录成功");
    }

}
