package com.yl.spring_aop;

import com.baobaotao.advisor.Seller;
import com.baobaotao.advisor.Waiter;

public class Test2 extends BaseTest {
    public static void main(String[] args) {
        Waiter waiter = (Waiter) getContext().getBean("waiter");
        waiter.serveTo("Jack");
        waiter.greetTo("Jack");
        Seller seller = (Seller) getContext().getBean("seller");
        seller.greetTo("Jack");
    }
}
