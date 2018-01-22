package com.yl;

import com.baobaotao.domain.TestB;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

public class BeanTest {
    @Test
    public void testClass() throws Exception {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazzB = loader.loadClass("com.baobaotao.domain.TestB");
        TestB testB = (TestB) clazzB.newInstance();

        Class clazzA = loader.loadClass("com.baobaotao.domain.TestA");
        Method method = clazzA.getMethod("setTestB", TestB.class);
        method.invoke(clazzB.newInstance(), null);
//        Object obj = clazz.newInstance();
//        TestA testA = (TestA) obj;
//        testA.setTestB(testB);
//        testA.print();
    }

    @Test
    public void test() {
        TestB testB;
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        Resource resource = resolver.getResource("classpath:/test-bean.xml");
//        BeanFactory beanFactory = new XmlBeanFactory(resource);
//        System.out.println("init BeanFactory");
//        testB = beanFactory.getBean("testB", TestB.class);
//        testB.printName();
//        testB.printAge();

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:test-bean.xml");
        testB = context.getBean("testB2", TestB.class);
        testB.print();

//        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(null);
//        System.out.println(webApplicationContext);

        ConfigurableApplicationContext configurableApplicationContext;

//        ApplicationContext context1 = new AnnotationConfigApplicationContext(Beans.class);
//        testB = (TestB) context1.getBean("testB1");
//        testB.print();
//
//        testB = (TestB) context1.getBean("testB2");
//        testB.print();
    }
}