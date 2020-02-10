package com.itdr.controller;

import com.itdr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //注册
    public String register(String username, String password,String shengxiao,int yuefen,String xingzuo){
        String register = userService.register(username, password,shengxiao,yuefen,xingzuo);
        return register;
    }

    //登陆
    public String login(String username, String password){
        String login = userService.login(username, password);
        return login;
    }

    //前世名字
    public String mingzi(String shengxiao, Integer yuefen, String xingzuo){
        String mingzi = userService.mingzi(shengxiao, yuefen, xingzuo);
        return mingzi;
    }
}
