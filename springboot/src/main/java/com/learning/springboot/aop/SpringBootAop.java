package com.learning.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Aspect
@Component
public class SpringBootAop {
    @Pointcut(value = "execution(* com.learning.springboot..*.run(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("before:执行方法前");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after:执行方法后");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing:异常抛出后");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning:返回结果后");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("around:环绕通知前");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around:环绕通知后");
    }

    //AOP进行事务管理
//    /**
//     * 注入事务管理器
//     */
//    @Autowired
//    public PlatformTransactionManager platformTransactionManager;
//
//    /**
//     * 设置事务拦截器
//     */
//    @Bean
//    public TransactionInterceptor transactionInterceptor(){
//        //设置事务属性
//        DefaultTransactionAttribute defaultTransactionAttribute = new DefaultTransactionAttribute();
//        //设置为读写事务
//        defaultTransactionAttribute.setReadOnly(false);
//        //通过方法名匹配事务
//        NameMatchTransactionAttributeSource nameMatchTransactionAttributeSource = new NameMatchTransactionAttributeSource();
//        //为save方法添加事务，事务属性为defaultTransactionAttribute设置的属性
//        nameMatchTransactionAttributeSource.addTransactionalMethod("save", defaultTransactionAttribute);
//        //昔年一个事务拦截器，使用platformTransactionAttribute作为事务管理器
//        return new TransactionInterceptor(platformTransactionManager, nameMatchTransactionAttributeSource);
//    }
//
//    @Bean
//    public Advisor advisor(){
//        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
//        //execution表达式匹配save方法
//        aspectJExpressionPointcut.setExpression("execution(* com.learning.springboot..*save(..))");
//        //返回aop切面，切面 = 切点 + 通知
//        return new DefaultPointcutAdvisor(aspectJExpressionPointcut, transactionInterceptor());
//    }
}
