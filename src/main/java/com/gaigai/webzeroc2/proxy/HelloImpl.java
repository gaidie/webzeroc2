package com.gaigai.webzeroc2.proxy;

/**
 * Created by Administrator on 2017/5/4.
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println(name);
    }
}
