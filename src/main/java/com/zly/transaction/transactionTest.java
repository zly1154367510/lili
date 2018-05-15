package com.zly.transaction;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by zly11 on 2018/5/13.
 */
@Component
@Aspect
public class transactionTest {

    //声明且切面包
    @Pointcut("execution(* com.zly.controller.*.*.*(..))")
    public void p(){

    }

    //前置通知
    @After("p()")
    public void startTransaction(){
        System.out.println("after aspect executed");
    }

    //后置通知
    @Before("p()")
    public void commitTransaction(){
        System.out.println("commit transaction ");
    }

    //环绕通知
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("begin transaction");

        joinPoint.proceed();

        System.out.println("commit transaction");
    }

}
