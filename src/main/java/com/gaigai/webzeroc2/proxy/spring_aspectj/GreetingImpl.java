package com.gaigai.webzeroc2.proxy.spring_aspectj;

import com.gaigai.webzeroc2.proxy.Greeting;
import org.springframework.stereotype.Component;

/**
 * Created by ga on 2017/5/9.
 */
@Component
public class GreetingImpl implements Greeting {

    @LogService
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
