package com.lixiaohao.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by lixiaohao on 2016/12/13
 *
 * @Description
 * @Create 2016-12-13 11:02
 * @Company
 */
@Component
@Aspect
public class SimpleAspect {
    @Pointcut("execution(* com.lixiaohao.aop.service.*Service*.*(..))")
    public void pointCut() {
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after aspect executed");
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        //如果需要这里可以取出参数进行处理
        Object[] args = joinPoint.getArgs();
        for(Object o:args){
            System.out.println("arg:"+o);
        }
        System.out.println("method:"+joinPoint.getSignature().getDeclaringType()+joinPoint.getSignature().getName());
        System.out.println("target:"+joinPoint.getTarget().getClass());
        System.out.println("before aspect executing");
    }

    @AfterReturning(pointcut = "pointCut()", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
        System.out.println("afterReturning executed, return result is "
                + returnVal);
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around start..");
        try {
            pjp.proceed();
        } catch (Throwable ex) {
            System.out.println("error in around");
            throw ex;
        }
        System.out.println("around end");
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "error")
    public void afterThrowing(JoinPoint jp, Throwable error) {
        System.out.println("error:" + error);
    }
}
