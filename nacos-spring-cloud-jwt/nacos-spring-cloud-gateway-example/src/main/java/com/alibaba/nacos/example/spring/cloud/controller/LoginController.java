package com.alibaba.nacos.example.spring.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.example.spring.cloud.mapper.UserMapper;
import com.alibaba.nacos.example.spring.cloud.model.MyUserDetails;
import com.alibaba.nacos.example.spring.cloud.model.ResultModel;
import com.alibaba.nacos.example.spring.cloud.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password) {

        MyUserDetails user = userMapper.getByUsername(username, password);
        ResultModel result = null;
        if (user == null) {
            result = ResultModel.builder().status("fail").build();
        } else {
            String jwtToken = JwtHelper.createJWT(user);
            result = ResultModel.builder().status("success").token(jwtToken).build();
        }

        return JSON.toJSON(result).toString();
    }
}
