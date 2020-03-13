package com.shiyanlou.spring.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutsDefinition {

    @Pointcut("execution(public * com.shiyanlou.spring.service.CustomerBo.*(..))")
    public void customer(){
    }
}
