package com.gaigai.webzeroc2.proxy.springaop;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/5/9.
 */
@Component
public class GreetingThrowAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception e){
        System.out.println("-----------------Throw Exception ---------------");
        System.out.println("Target Class :" + target.getClass().getName());
        System.out.println("---异常信息---" + e.getMessage());
        System.out.println("------------------------------------------------");
    }

}
