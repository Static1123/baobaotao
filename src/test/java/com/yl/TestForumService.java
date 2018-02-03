package com.yl;

import com.baobaotao.advice.GreetingBeforeAdvice;
import com.baobaotao.advice.Waiter;
import com.baobaotao.advice.impl.WaiterImpl;
import com.baobaotao.proxy.CglibProxy;
import com.baobaotao.proxy.PerformanceHandler;
import com.baobaotao.service.ForumService;
import com.baobaotao.service.impl.ForumServiceImpl;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

public class TestForumService {
    public static void main(String[] args) {
//        jdkProxy();
//        cglibProxy();
//        beforeAdvice();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:test-bean.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("Tom");
    }

    private static void beforeAdvice() {
        Waiter target = new WaiterImpl();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        //1.Spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
        pf.setOptimize(true);

        //2.设置代理目标
        pf.setTarget(target);

        //3.为目标添加增强
        pf.addAdvice(advice);

        //4.生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("Tom");
        proxy.serviceTo("Jack");

        //不会执行增强方法
        target.greetTo("John");
        target.serviceTo("Chen");
    }

    private static void jdkProxy() {
        ForumService target = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);
        //第二个参数需要代理实例实现的接口列表
        ForumService forumService1 = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
        forumService1.removeForum(100);
        forumService1.removeTopic(111);
    }

    private static void cglibProxy() {
        CglibProxy cglibProxy = new CglibProxy();
        ForumService forumService = (ForumService) cglibProxy.getProxy(ForumServiceImpl.class);
        forumService.removeTopic(100);
        forumService.removeForum(200);
    }
}