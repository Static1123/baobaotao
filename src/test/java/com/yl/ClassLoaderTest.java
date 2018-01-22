package com.yl;

import org.junit.Test;

public class ClassLoaderTest {
    @Test
    public void test() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}