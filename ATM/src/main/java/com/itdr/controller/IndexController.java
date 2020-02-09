package com.itdr.controller;

import com.itdr.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class IndexController {
//    private static ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    @Autowired
    private IndexService indexService;

    //模拟转账
    public String zz(String aname,String bname,int money){
        String s = indexService.tm(aname, bname, money);
        return s;
    }

    public void zz2(String aname,String bname,int money){
        indexService.tm2(aname, bname, money);
    }

}
