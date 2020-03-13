package com.shiyanlou.spring.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

//    @Before("execution(public * com.shiyanlou.spring.service.CustomerBo.addCustomer(..))")
//    public void logBefore(JoinPoint joinPoint){
//        System.out.println("logBefore is running ...");
//        System.out.println("hijacked" + joinPoint.getSignature().getName());
//        System.out.println("****************");
//    }
//
//    @After("execution(public * com.shiyanlou.spring.service.CustomerBo.deleteCustomer(..))")
//    public void logAfter(JoinPoint joinPoint){
//        System.out.println("logAfter is running ...");
//        System.out.println("hijacked" + joinPoint.getSignature().getName());
//        System.out.println("****************");
//    }

    @Before("com.shiyanlou.spring.aspectj.PointcutsDefinition.customer()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("logBefore is running ...");
        System.out.println("hijacked" + joinPoint.getSignature().getName());
        System.out.println("****************");
    }

    @After("com.shiyanlou.spring.aspectj.PointcutsDefinition.customer()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("logAfter is running ...");
        System.out.println("hijacked" + joinPoint.getSignature().getName());
        System.out.println("****************");
    }
}
