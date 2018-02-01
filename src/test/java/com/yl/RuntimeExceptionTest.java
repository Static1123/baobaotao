package com.yl;

public class RuntimeExceptionTest {
    public static void main(String[] args) {
        g();
    }

    private static void fun() {
        throw new RuntimeException("测试运行时异常");
    }

    private static void g() {
        fun();
    }
}