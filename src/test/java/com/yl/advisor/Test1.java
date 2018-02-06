package com.yl.advisor;

import com.baobaotao.advisor.Seller;
import com.baobaotao.advisor.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        String configPath = "classpath:test-bean.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) context.getBean("waiter1");
        Seller seller = (Seller) context.getBean("seller1");
        waiter.greetTo("Tom");
        waiter.serveTo("Tom");
        seller.greetTo("Tom");
    }
}