package com.proselyte.spel.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LogAspect {
    @Pointcut("execution(* com.proselyte.spel.aop.service..*.*(..))")
    private void anyMethod() {
    }

    @Before("anyMethod()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("log before: " + joinPoint);
    }

    @AfterReturning("anyMethod()")
    public void logAfterReturning(JoinPoint joinPoint) {
        System.out.println("log AfterReturning: " + joinPoint);
    }

    @AfterThrowing("anyMethod()")
    public void logAfterThrowing(JoinPoint joinPoint) {
        System.out.println("log AfterThrowing: " + joinPoint);
    }

    @Around("anyMethod()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("log Around before: " + System.currentTimeMillis());
        Object value;
        try {
            value = pjp.proceed();
        } catch (Throwable t) {
            System.out.println("Log around after with error: " + System.currentTimeMillis());
            return null;
        }
        System.out.println("log Around after: " + System.currentTimeMillis());
        return value;
    }
}
