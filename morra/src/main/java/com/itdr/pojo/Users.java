package com.itdr.pojo;
public class Users {

    private Integer id;
    private String uname;
    private String password;
    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    public Users(){

    }

    public Users(Integer id,String uname,String password,Integer score){
        this.id = id;
        this.uname = uname;
        this.password = password;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", score=" + score +
                '}';
    }
}
