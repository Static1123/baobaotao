package com.yl.spring_aop;

import com.baobaotao.advisor.Waiter;

public class Test3 extends BaseTest {
    public static void main(String[] args) {
        Waiter waiter = (Waiter) getContext().getBean("waiter");
        waiter.greetTo("Static");
    }
}