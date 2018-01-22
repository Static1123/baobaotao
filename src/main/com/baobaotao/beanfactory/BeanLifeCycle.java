package com.baobaotao.beanfactory;


import com.baobaotao.domain.TestB;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanLifeCycle {
    private static void LifeCycleInBeanFactory() {
        ClassPathResource resource = new ClassPathResource("resources/test-bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new TestBBeanPostProcessor());
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new TestBInstantiationAwareBeanPostProcessor());
        TestB testB = (TestB) beanFactory.getBean("testB");
        testB.print();
        testB.setName("Jhon");

        TestB testB1 = (TestB) beanFactory.getBean("testB");
        System.out.println(testB == testB1);
        ((XmlBeanFactory) beanFactory).destroySingletons();
    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}
