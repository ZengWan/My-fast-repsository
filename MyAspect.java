package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Repository;


@Aspect
@Repository
public class MyAspect{

    @Pointcut("execution(* org.example.aop.*.*(..))")
    public void cut(){

    }
    @Before(value ="cut()")
    public void before(){
        System.out.println("before...");
    }

    @AfterReturning(value = "cut()")
    public void afterReturn(){
        System.out.println("afterReturn...");

    }

    @After(value = "cut()")
    public void after(){
        System.out.println("after...");
    }
    @AfterThrowing(value = "cut()")
    public void afterThrow(){
        System.out.println("afterThrow...");

    }

    @Around(value = "cut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("环绕前置...");
        Object object=null;
        try {
        object = proceedingJoinPoint.proceed();
            System.out.println(proceedingJoinPoint.getTarget());
            System.out.println("环绕返回通知");
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("环绕异常通知");

        }
        System.out.println("环绕最终通知");
        return  object;

    }
}
