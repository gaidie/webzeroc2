package com.gaigai.webzeroc2.proxy.spring_aspectj_config;

import com.gaigai.webzeroc2.proxy.Greeting;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ga on 2017/5/9.
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectconfig/spring.xml");
        Greeting greeting = (Greeting) context.getBean("greetingImpl");
        greeting.sayHello("小盖");

        Apology apology = (Apology) greeting;
        apology.saySorry("小盖");
    }
}
