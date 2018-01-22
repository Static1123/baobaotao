package com.baobaotao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Static
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestB {
    private String name;
    private int age;

    public void print() {
        System.out.println("this is TestB:print();");
    }

    public void printName() {
        System.out.println(this.name);
    }

    public void printAge() {
        System.out.println(this.age);
    }
}