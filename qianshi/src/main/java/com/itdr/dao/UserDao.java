package com.itdr.dao;

import com.itdr.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jt;

    //查询是否已经注册
//    public String selectByName(String username){
//        String sql = "SELECT id from qianshi_users where username = ?";
//        List<Map<String, Object>> m = jt.queryForList(sql, username);
//        for (Map<String, Object> map:m){
//            for (String u :map.keySet()) {
//                return (String) map.get(u);
//            }
//        }
//        return null;
//    }
    //注册
    public int InsertByNameAndPassword(String username,String password,String shengxiao,int yuefen,String xingzuo){
        String sql = "Insert into qianshi_users values(null,?,?,?,?,?)";
        int update = jt.update(sql, username, password,shengxiao,yuefen,xingzuo);
        return update;
    }


    //登陆
    public String SelectByNameAndPassword(String username,String password){
        String sql = "Select username from qianshi_users where username = ? and password = ?";
        List<Map<String, Object>> maps = jt.queryForList(sql, username, password);
        for (Map<String, Object> map:maps){
            for(String u : map.keySet()){
                return (String) map.get(u);
            }
        }
//        Map<String, Object> map = jt.queryForMap(sql, username, password);
//        String s = (String) map.get("id");
        return null;
    }


    //查询前世的姓氏
    public String SelectByShuxin(String shengxiao){
        String sql = "Select xingshi from qianshi_xing where shengxiao = ?";
        List<Map<String, Object>> maps = jt.queryForList(sql,shengxiao);
        for(Map<String, Object> map:maps){
            for(String u:map.keySet()){
                return (String) map.get(u);
            }
        }
        return null;
    }
    //查询前世的第二个字
    public String SelectByYuefen(Integer yuefen){
        String sql2 = "Select dier from qianshi_diergezi where yuefen = ?";
        List<Map<String, Object>> map2 = jt.queryForList(sql2,yuefen);
        for(Map<String, Object> map:map2){
            for(String u:map.keySet()){
                return (String) map.get(u);
            }
        }
        return null;
    }
    //查询前世的第三个字
    public String SelectByXingzuo(String xingzuo){
        String sql3 = "Select disan from qianshi_disangezi where xingzuo = ?";
        List<Map<String, Object>> map3 = jt.queryForList(sql3,xingzuo);
        for(Map<String, Object> map:map3){
            for(String u:map.keySet()){
                return (String) map.get(u);
            }
        }
        return null;
    }

}
