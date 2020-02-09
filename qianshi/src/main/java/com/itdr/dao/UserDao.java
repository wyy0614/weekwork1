package com.itdr.dao;

import com.itdr.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jt;

    //查询是否已经注册
    public Integer selectByName(String username){
        String sql = "SELECT id from qianshi_users where username = ?";
        Map<String, Object> m = jt.queryForMap(sql, username);
        Integer id = (Integer) m.get("id");
        return id;
    }
    //注册
    public int InsertByNameAndPassword(String username,String password){
        String sql = "Insert into qianshi_users values(null,?,?)";
        int update = jt.update(sql, username, password);
        return update;
    }


    //登陆
    public Integer SelectByNameAndPassword(String username,String password){
        String sql = "Select id from qianshi_users where username = ? and password = ?";
        Map<String, Object> m = jt.queryForMap(sql, username, password);
        Integer id = (Integer) m.get("id");
        return id;
    }

    //查询前世的名字
    public String SelectByShuxin(String shengxiao,Integer yuefen,String xingzuo){

        String sql = "Select xinshi from qianshi_xing where shengxiao = ?";
        String sql2 = "Select dier from qianshi_diergezi where yuefen = ?";
        String sql3 = "Select disan from qianshi_disangezi where xingzuo = ?";
        Map<String, Object> m1 = jt.queryForMap(sql, shengxiao);
        Map<String, Object> m2 = jt.queryForMap(sql2, yuefen);
        Map<String, Object> m3 = jt.queryForMap(sql3, xingzuo);

        String s =(String) m1.get("shengxiao");
        String s2 =(String) m2.get("yuefen");
        String s3 =(String) m3.get("xingzuo");
        return s+s2+s3;
    }

}
