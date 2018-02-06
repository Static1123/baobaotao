package com.yl.advisor;

import com.baobaotao.advisor.Waiter;
import com.baobaotao.advisor.WaiterDelegate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        String configPath = "classpath:test-bean.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) context.getBean("waiter4");
        WaiterDelegate waiterDelegate = new WaiterDelegate();
        waiterDelegate.setWaiter(waiter);
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        waiterDelegate.service("Peter");
    }
}