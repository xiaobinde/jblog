package com.blog.rest.controller;

import com.blog.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuhb on 2017/1/11.
 */
@RequestMapping("admin/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> doIndex(){
        return null;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<String> doLogin(@RequestParam("username") String username, @RequestParam("password") String password){

        try {
            String token = this.userService.doLogin(username, password);
            if (StringUtils.isEmpty(token)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(token);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
