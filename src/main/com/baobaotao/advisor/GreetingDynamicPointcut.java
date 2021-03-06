package com.baobaotao.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Static
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
    private static List<String> specialClientList = new ArrayList<String>();

    static {
        specialClientList.add("Tom");
        specialClientList.add("John");
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                System.out.println("调用getClassFilter()对[" + clazz.getName() + "]做静态检查.");
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }

    @Override
    public boolean matches(Method method, Class clazz) {
        System.out.println("调用matches(method,clazz)" + clazz.getName() + "." + method.getName() + "做静态检查");
        boolean f = "greetTo".equals(method.getName());
        System.out.println(f);
        return f;
    }

    /**
     * boolean matches(Method method, Class clazz) 返回true调用
     *
     * @param method
     * @param targetClass
     * @param args
     * @return
     */
    public boolean matches(Method method, Class<?> targetClass, Object[] args) {
        System.out.println("调用matches(method,clazz)" + targetClass.getName() + "." + method.getName() + "做动态检查");
        String clientName = String.valueOf(args[0]);
        return specialClientList.contains(clientName);
    }
}