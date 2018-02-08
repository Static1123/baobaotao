package com.baobaotao.aspectj.example;

import com.baobaotao.advice.Waiter;
import com.baobaotao.advice.impl.WaiterImpl;
import com.baobaotao.aspectj.PreGreetingAspect;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @author Administrator
 */
public class AspectJProxyTest {
    public static void main(String[] args) {
        Waiter waiter = new WaiterImpl();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(waiter);
        factory.addAspect(PreGreetingAspect.class);
        Waiter proxy = factory.getProxy();
        proxy.serviceTo("Tom");
        proxy.greetTo("Jack");
    }
}
