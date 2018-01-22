package com.baobaotao.beanfactory;

import com.baobaotao.domain.TestB;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equalsIgnoreCase("testB")) {
            TestB testB = (TestB) bean;
            if (testB.getName() == null) {
                System.out.println("调用[BeanPostProcessor].postProcessBeforeInitialization(),name为null,默认设置为[Jim]");
                testB.setName("Jim");
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equalsIgnoreCase("testB")) {
            TestB testB = (TestB) bean;
            if (testB.getAge() > 10) {
                System.out.println("调用[BeanPostProcessor].postProcessAfterInitialization(),将age调整为8");
                testB.setAge(8);
            }
        }
        return bean;
    }
}