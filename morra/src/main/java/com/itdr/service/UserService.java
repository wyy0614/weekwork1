package com.itdr.service;

public interface UserService {
    //注册
    int register(String uname,String password);

    //登陆
    int login(String uname,String password);

}
