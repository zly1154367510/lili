package com.zly.transaction;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zly11 on 2018/5/15.
 */
@Component
@Aspect
public class LogTransaction {
    //声明且切面包
    @Pointcut("execution(* com.zly.controller.*.*.*(..))")
    public void p(){

    }
    //前置通知
    @After("p()")
    public void startTransaction(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        HttpSession httpSession = request.getSession();
        System.out.println("我是aop session"+httpSession.getId());
        System.out.println("after aspect executed");
    }
}
