package com.gaigai.webzeroc2.proxy.springaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareAnnotation;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/9.
 */
@Aspect
@Component
public class GreetingAspect {

    @DeclareParents(value = "com.gaigai.webzeroc2.proxy.springaop.GreetingImpl",
            defaultImpl = ApologyImpl.class)
    private Apology apology;

    @Around("@annotation(com.gaigai.webzeroc2.proxy.springaop.LogAspect)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        before();
        Object result = point.proceed();
        after();
        return result;
    }

//    @Around("execution(* com.gaigai.webzeroc2.proxy.springaop.GreetingImpl.*(..))")
//    public Object around(ProceedingJoinPoint point) throws Throwable {
//        before();
//        Object result = point.proceed();
//        after();
//        return result;
//    }

    private void after(){
        System.out.println("after");
    }

    public void before(){
        System.out.printf("before");
    }

}
