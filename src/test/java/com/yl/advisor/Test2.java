package com.yl.advisor;

import com.baobaotao.advisor.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        String configPath = "classpath:test-bean.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) context.getBean("waiter2");
        waiter.greetTo("John");
        waiter.serveTo("John");
    }
}
