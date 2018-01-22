package com.baobaotao.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

public class TestBInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        if ("testB".equalsIgnoreCase(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor.postProcessBeforeInstantiation()...");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("testB".equalsIgnoreCase(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor.postProcessAfterInstantiation()...");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {
        if ("testB".equalsIgnoreCase(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor.postProcessPropertyValues()...");
        }
        return pvs;
    }
}
