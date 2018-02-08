package com.baobaotao.aspectj.anno;

import com.baobaotao.service.impl.ForumServiceImpl;

import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class TestTool {
    public static void main(String[] args) {
        Class clazz = ForumServiceImpl.class;
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);
        for (Method method : methods) {
            NeedTest nt = method.getAnnotation(NeedTest.class);
            if (nt == null) {
                continue;
            }
            if (nt.value()) {
                System.out.println(method.getName() + "()需要测试");
            } else {
                System.out.println(method.getName() + "()不需要测试");
            }
        }
    }
}