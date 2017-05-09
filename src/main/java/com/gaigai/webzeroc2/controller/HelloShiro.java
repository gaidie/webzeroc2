package com.gaigai.webzeroc2.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/5/5.
 */
public class HelloShiro {
    private static final Logger logger = LoggerFactory.getLogger(HelloShiro.class);

    public static void main(String[] args) {
        //初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //登录
        UsernamePasswordToken token = new UsernamePasswordToken("shiro", "201314");
        subject.login(token);

        logger.error("登录成功", subject.getPrincipal());

        subject.logout();

    }

}
