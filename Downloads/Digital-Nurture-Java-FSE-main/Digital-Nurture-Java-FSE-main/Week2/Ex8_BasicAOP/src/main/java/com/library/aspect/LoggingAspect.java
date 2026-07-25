package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    /**
     * Before advice: runs BEFORE any method in com.library.service package
     */
    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[AOP - BEFORE] Method called: "
                + joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName());
    }

    /**
     * After advice: runs AFTER any method in com.library.service package
     */
    @After("execution(* com.library.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[AOP - AFTER]  Method completed: "
                + joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName());
    }
}
