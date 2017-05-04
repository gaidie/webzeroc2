package com.gaigai.webzeroc2.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/5/4.
 */
public class HelloProxy implements Hello {

    private Hello hello;

    public HelloProxy(){
        hello = new HelloImpl();
    }

    @Override
    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    private void after() {
        System.out.println("after");
    }

    private void before() {
        System.out.println("before");
    }

    public static void main(String[] args) {
//         HelloProxy helloProxy = new HelloProxy();
//        helloProxy.say("小盖");

        Hello hello = new HelloImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(hello);

//        Hello helloProxy = (Hello) Proxy.newProxyInstance(
//                hello.getClass().getClassLoader(),
//                hello.getClass().getInterfaces(),
//                dynamicProxy
//        );
//        helloProxy.say("小洞");
        Hello hello1 = dynamicProxy.getProxy();
        hello1.say("广场舞");
    }
}
