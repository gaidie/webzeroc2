package com.gaigai.webzeroc2.proxy.spring_aspectj_config;

/**
 * Created by ga on 2017/5/9.
 */
public class ApologyImpl implements Apology {
    @Override
    public void saySorry(String name) {
        System.out.println("抱歉：" + name);
    }
}
