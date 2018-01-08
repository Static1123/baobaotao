package com.baobaotao.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Static
 */
@Data
public class TestA implements Serializable {
    private TestB testB;

    public void print() {
        System.out.println("this is TestA:print();");
        testB.print();
    }
}