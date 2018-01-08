package com.yl;

import org.junit.Test;

public class StringTest {
    @Test
    public void test() {
        String a = "word";
        test1(a);
        System.out.println(a);

        StringBuffer sb = new StringBuffer();
        sb.append(a);
        test2(sb);
        System.out.println(sb.toString());
    }

    private String test1(String str) {
        str = "Hello";
        return str;
    }

    private String test2(StringBuffer sb) {
        sb = new StringBuffer();
        sb.append("bbb");
        return sb.toString();
    }
}