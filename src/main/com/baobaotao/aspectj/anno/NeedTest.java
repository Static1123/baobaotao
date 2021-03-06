package com.baobaotao.aspectj.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义注解
 */
//声明注解的保留期限
@Retention(RetentionPolicy.RUNTIME)
//声明可以使用该注解的目标类型
@Target(ElementType.METHOD)
public @interface NeedTest {
    boolean value() default true;
}