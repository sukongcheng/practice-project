package com.shiyanlou.spring.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class HijackAroundMethod implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Method's name:" + methodInvocation.getMethod().getName());
        System.out.println("Method's argument:" + methodInvocation.getArguments());

        System.out.println("HijackAroundMethod : Before method hijacked!");

        try {
            Object result = methodInvocation.proceed();
            System.out.println("HijackAroundMethod : After method hijacked!");
            return result;
        }catch(IllegalArgumentException e){
            System.out.println("HijackAroundMethod : Throw exception hijacked!");
            throw e;
        }

    }
}
