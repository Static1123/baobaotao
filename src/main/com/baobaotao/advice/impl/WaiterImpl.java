package com.baobaotao.advice.impl;

import com.baobaotao.advice.Waiter;

public class WaiterImpl implements Waiter {
    public void greetTo(String name) {
        System.out.println("greet to " + name + "...");
    }

    public void serviceTo(String name) {
        System.out.println("serving to " + name + "...");
    }
}