package com.baobaotao.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreatingInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        String clientName = String.valueOf(args[0]);
        System.out.println("How are you ! Mr." + clientName + ".");
        Object obj = methodInvocation.proceed();
        System.out.println("Pls enjoy yourself!");
        return obj;
    }
}