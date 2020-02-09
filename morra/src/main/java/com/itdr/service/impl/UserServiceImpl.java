package com.itdr.service.impl;

import com.itdr.dao.UsersDao;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;

public class UserServiceImpl implements UserService {
    private UsersDao usersDao = new UsersDao();
    //用户注册
    @Override
    public int register(String uname, String password) {
        //非空判断
        if(uname == null || "".equals(uname)){
            return 0;
        }
        if(password == null || "".equals(password)){
            return 0;
        }
        Users users = usersDao.selectByUname(uname);
        //用户名存在
        if(users != null){
            return 0;
        }
        //用户名不存在，注册
        int i = usersDao.insertByUnameAndPassword(uname, password);
        return i;
    }

    @Override
    public int login(String uname, String password) {
        //参数非空判断
        if (uname == null || "".equals(uname)) {
            return 0;
        }
        if (password == null || "".equals(password)) {
            return 0;
        }
        Users users = usersDao.selectByUnameAndPassword(uname, password);
        //如果返回值空，当前对象不存在，登陆失败
        if (users == null) {
            return 0;
        }
        //成功返回成功数据
        return 1;
    }
}
