package com.gaigai.webzeroc2.proxy.springaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/9.
 */
@Component
public class GreetingAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object result = methodInvocation.proceed();
        after();
        return result;
    }

    private void before(){
        System.out.println("我是大师兄，走在前面");
    }

    private void after(){
        System.out.println("我是沙师弟，走在后面");
    }
}
