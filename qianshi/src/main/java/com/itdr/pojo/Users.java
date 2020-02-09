package com.itdr.pojo;

public class Users {

    private Integer id;
    private String username;
    private String password;
    private String shengxiao;
    private Integer yuefen;
    private String xingzuo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShengxiao() {
        return shengxiao;
    }

    public void setShengxiao(String shengxiao) {
        this.shengxiao = shengxiao;
    }

    public Integer getYuefen() {
        return yuefen;
    }

    public void setYuefen(Integer yuefen) {
        this.yuefen = yuefen;
    }

    public String getXingzuo() {
        return xingzuo;
    }

    public void setXingzuo(String xingzuo) {
        this.xingzuo = xingzuo;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", shengxiao='" + shengxiao + '\'' +
                ", yuefen=" + yuefen +
                ", xingzuo='" + xingzuo + '\'' +
                '}';
    }
}
