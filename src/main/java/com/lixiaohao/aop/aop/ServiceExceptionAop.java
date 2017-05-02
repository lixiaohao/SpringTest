package com.lixiaohao.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by lixiaohao on 2017/4/28
 *
 * @Description
 * @Create 2017-04-28 11:25
 * @Company
 */
@Component
@Aspect
public class ServiceExceptionAop {
    @Pointcut("execution(* com.lixiaohao.aop.service.*Service*.*(..))")
    public void pointCut() {
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
    }

    @AfterReturning(pointcut = "pointCut()", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around start");
        try {
            pjp.proceed();
        } catch (Throwable ex) {
            throw ex;
        }
        System.out.println("around end");
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "error")
    public void afterThrowing(JoinPoint jp, Throwable error) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        error.printStackTrace(printWriter);
        System.out.println("-------------------------------");
        String exceptionStr = stringWriter.toString();
        System.out.println(exceptionStr);
    }
}
