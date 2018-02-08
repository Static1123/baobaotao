package com.yl.spring_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-aop.xml");

    protected static ApplicationContext getContext() {
        return context;
    }
}