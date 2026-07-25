package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    /**
     * Around advice that logs the execution time of every method
     * in the com.library package.
     */
    @Around("execution(* com.library..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        System.out.println("[LoggingAspect] Starting method: " + joinPoint.getSignature().getName());

        Object result = joinPoint.proceed(); // Execute the actual method

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("[LoggingAspect] Finished method: " + joinPoint.getSignature().getName()
                + " | Execution time: " + duration + " ms");

        return result;
    }
}
