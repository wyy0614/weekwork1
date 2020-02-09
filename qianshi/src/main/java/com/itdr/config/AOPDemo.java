package com.itdr.config;

import org.aspectj.lang.ProceedingJoinPoint;

public class AOPDemo {
    //前置增强方法，配置切面的类中方法在执行前先经过这里
    public void befor(){
        System.out.println("前置通知");
    }
    //后置增强方法，配置切面的类中方法在执行后先经过这里，该方法还可以获取到类中方法的返回参数
    public void af(int num){
        System.out.println("开启后置通知：删除"+num);
    }

    public void ar(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开启环绕前通知");
        Object proceed = joinPoint.proceed();
        System.out.println("开启环绕后通知");
    }

    public void th(Throwable thr){
        System.out.println("开启异常通知"+thr.getMessage());
    }

    public void zz(){
        System.out.println("无论怎么样都启动了最终通知");
    }


}
