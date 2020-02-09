package com.itdr.service.impl;

import com.itdr.dao.UserDao;
import com.itdr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    //注册
    @Override
    public String register(String username, String password) {
        //非空判断
        if (username == null || "".equals(username)) {
            return "用户名格式错误";
        }
        if (password == null || "".equals(password)) {
            return "密码格式错误";
        }

        Integer integer = userDao.selectByName(username);
        if (integer != 0) {
            return "用户已经注册";
        }
        int i = userDao.InsertByNameAndPassword(username, password);
        if (i == 1) {
            return "注册成功";
        }
        return "注册失败";
    }

    //登陆
    @Override
    public String login(String username, String password) {

        if (username == null || "".equals(username)) {
            return "用户名错误";
        }
        if (password == null || "".equals(password)) {
            return "密码错误";
        }
        Integer integer = userDao.SelectByNameAndPassword(username, password);
        if (integer != 0) {
            return "登陆成功";
        }
        return "登陆失败";
    }

    //测试前世名字
    @Override
    public String mingzi(String shengxiao, Integer yuefen, String xingzuo) {
        if (shengxiao == null || "".equals(shengxiao)) {
            return "错误";
        }
        if (yuefen == 0 || "".equals(yuefen)) {
            return "错误";
        }
        if (xingzuo == null || "".equals(xingzuo)) {
            return "错误";
        }

        String s = userDao.SelectByShuxin(shengxiao, yuefen, xingzuo);
        return s;
    }


}
