package com.baobaotao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Static
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestA implements Serializable {
    private TestB testB;
    private String name;

    public void print() {
        System.out.println("this is TestA:print();");
        testB.print();
    }
}