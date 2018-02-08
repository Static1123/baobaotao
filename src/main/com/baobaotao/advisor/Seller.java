package com.baobaotao.advisor;

/**
 * @author Static
 */
public class Seller implements BaseSeller {
    public void greetTo(String name) {
        System.out.println("seller greet to " + name + "...");
    }
}