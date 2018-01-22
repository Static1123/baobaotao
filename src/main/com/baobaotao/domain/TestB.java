package com.baobaotao.domain;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author Static
 */
@AllArgsConstructor
public class TestB implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String name;
    private int age;

    public TestB() {
        System.out.println("TestB 构造函数...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("调用setName()成员方法...");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    public void init() {
        System.out.println("调用自定义init()方法...");
        this.age = 12;
    }

    public void print() {
        System.out.println("this is TestB:print();name=" + name + ",age=" + age);
    }

    public void printName() {
        System.out.println(this.name);
    }

    public void printAge() {
        System.out.println(this.age);
    }

    private BeanFactory beanFactory;
    private String beanName;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory()方法...");
        this.beanFactory = beanFactory;
    }

    public void setBeanName(String name) {
        System.out.println("调用BeanNameWare.setBeanName()方法...");
        this.beanName = name;
    }

    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destroy()方法...");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()方法...");
    }
}