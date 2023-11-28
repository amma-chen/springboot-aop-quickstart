package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
//@Aspect
@Component
public class MyAspect1 {

    @Pointcut("execution(* com.itheima.service.*.*(..))")//提前定义切入点表达式,抽取方法
    public void pt(){}

    @Before("pt()")//*是所有方法，..是方法形参
    public void before(){
        log.info("before ...");
    }

    @Around("pt()")//切入点表达式 ,执行所有接口方法时，都会执行这段共性的逻辑
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {//声明参数ProceedingJoinPoint
        log.info("around before ...");//前
        //调用目标对象的原始方法执行
        Object result = proceedingJoinPoint.proceed();//调用proceed()方法，返回值是object类型对象
        log.info("around after ...");//后
        return result;
    }

    @After("pt()")
    public void after(){
        log.info("after ...");
    }


    @AfterReturning("pt()")//执行后正常返回
    public void afterReturning(){
        log.info("afterReturning ...");
    }

    @AfterThrowing("pt()")
    public void afterThrowing(){
        log.info("afterThrowing ...");
    }

}
