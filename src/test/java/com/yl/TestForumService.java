package com.yl;

import com.baobaotao.proxy.CglibProxy;
import com.baobaotao.proxy.PerformanceHandler;
import com.baobaotao.service.ForumService;
import com.baobaotao.service.impl.ForumServiceImpl;

import java.lang.reflect.Proxy;

public class TestForumService {
    public static void main(String[] args) {
        jdkProxy();
        cglibProxy();
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