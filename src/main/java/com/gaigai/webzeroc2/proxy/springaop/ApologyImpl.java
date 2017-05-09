package com.gaigai.webzeroc2.proxy.springaop;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/9.
 */
@Component
public class ApologyImpl implements Apology {
    @Override
    public void saySorry(String name) {
        System.out.println("日志你能出来么" +name);
    }
}
