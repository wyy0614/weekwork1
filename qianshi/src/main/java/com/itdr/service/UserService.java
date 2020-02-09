package com.itdr.service;

public interface UserService {
    String register(String username,String password);
    String login(String username,String password);
    String mingzi(String shengxiao,Integer yuefen,String xingzuo);

}
