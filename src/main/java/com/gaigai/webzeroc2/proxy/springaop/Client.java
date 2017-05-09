package com.gaigai.webzeroc2.proxy.springaop;

import com.gaigai.webzeroc2.proxy.Greeting;
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
//        greeting.saySorry("springAOP");
//
//        ProxyFactory proxyFactory = new ProxyFactory();
//        proxyFactory.setTarget(new GreetingImpl());
//        proxyFactory.addAdvice(new GreetingBothAdvice());
//        Greeting greeting = (Greeting) proxyFactory.getProxy();
//        greeting.saySorry("advice");

//        ProxyFactory proxyFactory = new ProxyFactory();
//        proxyFactory.setTarget(new GreetingImpl());
//        proxyFactory.addAdvice(new GreetingAroundAdvice());
//        Greeting greeting = (Greeting) proxyFactory.getProxy();
//        greeting.saySorry("环绕增强");

//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Greeting greeting = (Greeting) context.getBean("greetingProxy");
//        greeting.saySorry("我是配置文件出来的");

//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        GreetingImpl greeting = (GreetingImpl) context.getBean("greetingProxy");
//        greeting.saySorry("小盖");
//
//        Apology apology = (Apology) greeting;
//        apology.saySorry("小盖");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        GreetingImpl greeting = (GreetingImpl) context.getBean("greetingImpl");
//        greeting.saySorry("小盖");

        Greeting greeting = (Greeting) context.getBean("greetingImpl");
        greeting.sayHello("小盖");
        Apology apology = (Apology) greeting;
        apology.saySorry("小盖");
    }
}
