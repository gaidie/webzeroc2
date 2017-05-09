package com.gaigai.webzeroc2.proxy.spring_aspectj;

import com.gaigai.webzeroc2.proxy.Greeting;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/9.
 */
public class Client {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("springaspect/spring.xml");
//        GreetingImpl greeting = (GreetingImpl) context.getBean("greetingImpl");
//        greeting.saySorry("小盖");

        Greeting greeting = (Greeting) context.getBean("greetingImpl");
        greeting.sayHello("Jack");
    }
}
