package com.gaigai.webzeroc2.proxy.springaop;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/9.
 */
@Component
public class GreetingImpl implements Greeting{

    @LogAspect
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
        //学习一下抛出增强
//        throw new RuntimeException("抛出增强爆出来的错误Error");
    }

    public void goodMorning(){
        System.out.println("早上好。。。");
    }

    public void goodNight(){
        System.out.println("晚上好。。。");
    }
}
