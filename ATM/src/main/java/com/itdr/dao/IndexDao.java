package com.itdr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IndexDao {

    @Autowired
    private JdbcTemplate jt;

    public int updateByName(String name, int money){
        //创建容器
        String sql = "update users set score = score - ? where uname = ?";
        int i = jt.update(sql, money, name);
        return i;
    }
    public int updateByName2(String name,int money){
        //创建容器
        String sql = "update users set score = score + ? where uname = ?";
        int i = jt.update(sql, money, name);
        return i;
    }
}
