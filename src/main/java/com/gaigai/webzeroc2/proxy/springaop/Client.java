package com.gaigai.webzeroc2.proxy.springaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/9.
 */
public class Client {

    public static void main(String[] args) {
//        ProxyFactory proxyFactory = new ProxyFactory();
//        proxyFactory.setTarget(new GreetingImpl());
//        proxyFactory.addAdvice(new GreetingBeforeAdvice());
//        proxyFactory.addAdvice(new GreetingAfterAdvice());
//        Greeting greeting = (Greeting) proxyFactory.getProxy();
//        greeting.sayHello("springAOP");
//
//        ProxyFactory proxyFactory = new ProxyFactory();
//        proxyFactory.setTarget(new GreetingImpl());
//        proxyFactory.addAdvice(new GreetingBothAdvice());
//        Greeting greeting = (Greeting) proxyFactory.getProxy();
//        greeting.sayHello("advice");

//        ProxyFactory proxyFactory = new ProxyFactory();
//        proxyFactory.setTarget(new GreetingImpl());
//        proxyFactory.addAdvice(new GreetingAroundAdvice());
//        Greeting greeting = (Greeting) proxyFactory.getProxy();
//        greeting.sayHello("环绕增强");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Greeting greeting = (Greeting) context.getBean("greetingProxy");
        greeting.sayHello("我是配置文件出来的");

    }
}
