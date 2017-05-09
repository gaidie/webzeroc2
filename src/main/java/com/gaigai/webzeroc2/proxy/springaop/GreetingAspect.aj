package com.gaigai.webzeroc2.proxy.springaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareAnnotation;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.beans.factory.annotation.Autowired;
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

}
