package com.baobaotao.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @author Static
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    /**
     * 匹配切点方法：方法名为greetTo
     *
     * @param method
     * @param targetClass
     * @return
     */
    public boolean matches(Method method, Class<?> targetClass) {
        return "greetTo".equals(method.getName());
    }

    /**
     * 切点类匹配规则：为Waiter的类或子类
     *
     * @return
     */
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
}