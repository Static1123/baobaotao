package com.yl;

import com.baobaotao.domain.TestB;
import org.junit.Test;

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
}