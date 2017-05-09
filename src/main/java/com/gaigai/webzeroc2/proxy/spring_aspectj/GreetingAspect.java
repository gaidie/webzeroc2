package com.gaigai.webzeroc2.proxy.spring_aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by ga on 2017/5/9.
 */
@Aspect
@Component
public class GreetingAspect {

    @Around("@annotation(com.gaigai.webzeroc2.proxy.spring_aspectj.LogService)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        before();
        Object result = point.proceed();
        after();
        return result;
    }

    private void after() {
        System.out.println("我走在后面，我是沙师弟");
    }

    private void before() {
        System.out.println("我走在前面，我是大师兄");
    }

}
