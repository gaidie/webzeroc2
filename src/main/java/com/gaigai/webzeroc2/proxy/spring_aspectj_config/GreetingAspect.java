package com.gaigai.webzeroc2.proxy.spring_aspectj_config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by ga on 2017/5/9.
 */
@Aspect
@Component
public class GreetingAspect {

    @DeclareParents(value = "com.gaigai.webzeroc2.proxy.spring_aspectj_config.GreetingImpl",
    defaultImpl = ApologyImpl.class)
    private Apology apology;

}
