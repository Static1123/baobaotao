package com.baobaotao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class PerformanceHandler implements InvocationHandler {
    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  代理实例
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
        Object obj = method.invoke(target, args);
        PerformanceMonitor.end();
        return obj;
    }
}