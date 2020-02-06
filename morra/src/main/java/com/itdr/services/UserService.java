package com.itdr.services;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;

public interface UserService {
    //注册
    int register(String uname,String password);

    //登陆
    int login(String uname,String password);

}
