package com.gaigai.webzeroc2.proxy.spring_aspectj_config;

import com.gaigai.webzeroc2.proxy.Greeting;
import com.gaigai.webzeroc2.proxy.springaop.LogAspect;
import org.springframework.stereotype.Component;

/**
 * Created by ga on 2017/5/9.
 */
@Component
public class GreetingImpl implements Greeting {
    @LogAspect
    @Override
    public void sayHello(String name) {
        System.out.println("你好" + name);
    }
}
