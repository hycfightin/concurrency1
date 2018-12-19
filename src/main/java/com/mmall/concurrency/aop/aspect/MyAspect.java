package com.mmall.concurrency.aop.aspect;

import com.mmall.concurrency.aop.validator.userValidator;
import com.mmall.concurrency.aop.validator.userValidatorImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
public class MyAspect {
//    @DeclareParents(
//            value = "com.mmall.concurrency.aop.aopreal.UserServiceImpl+",
//            defaultImpl = userValidatorImpl.class)
//    public userValidator userValidator;

    @Pointcut("execution(* com.mmall.concurrency.aop.aopreal.UserServiceImpl.printUser(..))")
    public void pointCut() {}


    //@Before("execution(*com.mmall.concurrency.aop.aopreal.UserServiceImpl.printUser(...))")
    //寻找切点的正则表达。可以通过pointCut方法来简化
    @Before("pointCut()")//对  对应切点的引用
    public  void before() {
        System.out.println("before");
    }
    //@After("execution(*com.mmall.concurrency.aop.aopreal.UserServiceImpl.printUser(...))")
    @After("pointCut()")
    public void around() {
        System.out.println("after");
    }
    //@AfterReturning("execution(*com.mmall.concurrency.aop.aopreal.UserServiceImpl.printUser(...))")
    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning");
    }
    //@AfterThrowing("execution(*com.mmall.concurrency.aop.aopreal.UserServiceImpl.printUser(...))")
    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }
    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws  Throwable{
        System.out.println("around before");
        joinPoint.proceed();
        System.out.println("around after");
    }


}
