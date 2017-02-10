package com.blog.rest.service;

import com.alibaba.fastjson.JSON;
import com.blog.common.service.RedisService;
import com.blog.mapper.UserMapper;
import com.blog.pojo.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuhb on 2017/1/11.
 */
@Service
public class UserService extends BaseService<User>{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;

    public String doLogin(String username,String password){

        User record = new User();
        record.setUsername(username);
        User user = this.userMapper.selectOne(record);
        if (null == user){
            return null;
        }
//        if (!StringUtils.equals(DigestUtils.sha256Hex(password+user.getSalt()),user.getPassword())){
//            return null;
//        }

        //登录成功，生成token
        String token = DigestUtils.sha256Hex(System.currentTimeMillis()+username);

        //将用户保存到redis中
        this.redisService.set("TOKEN_"+ token, JSON.toJSONString(user),60*30);

        return token;
    }

}
