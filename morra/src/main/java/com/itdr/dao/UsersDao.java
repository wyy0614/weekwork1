package com.itdr.dao;

import com.itdr.pojo.Users;
import com.itdr.utils.C3P0Util;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;

public class UsersDao {
    static QueryRunner queryRunner = new QueryRunner(C3P0Util.getCom());
    //注册前先查询是否存在用户，若存在不可再注册
    public Users selectByUname(String uname){
        Users u = null;
        String sql = "SELECT id FROM users WHERE uname = ?";
        try {
            u = queryRunner.query(sql, new BeanHandler<Users>(Users.class), uname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    //若不存在，注册用户
    public int insertByUnameAndPassword(String uname,String password){
        String sql = "INSERT INTO users VALUES (null,?,?,0) ";
        int i =0;
        try {
            i = queryRunner.update(sql, uname, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    //用户登陆,根据用户名和密码判断是否登陆成功
    public Users selectByUnameAndPassword(String uname,String password){
        Users u = null;
        String sql = "SELECT * FROM users WHERE uname = ? and password = ?";
        try {
            u = queryRunner.query(sql, new BeanHandler<Users>(Users.class), uname, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    //开始游戏
    public int startGame(String uname,Integer score){
        int i =0;
        String sql = "update users set score = score + ? where uname = ?";
        try {
            i = queryRunner.update(sql,uname, score);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }



}
