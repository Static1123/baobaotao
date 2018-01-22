package com.baobaotao.beanfactory;

import com.baobaotao.domain.TestB;

public class CustomFactory {
    public TestB getTestB() {
        TestB testB = new TestB();
        testB.setName("Jim");
        testB.setAge(22);
        return testB;
    }

    public static TestB getTestB1() {
        TestB testB = new TestB();
        testB.setName("Static");
        testB.setAge(24);
        return testB;
    }
}