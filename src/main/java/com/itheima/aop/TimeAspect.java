package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect
public class TimeAspect {
    //指定逻辑作用在哪些方法上
    @Around("com.itheima.aop.MyAspect1.pt()")//切入点表达式 ,执行所有接口方法时，都会执行这段共性的逻辑
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {

        //记录开始时间
        long begin = System.currentTimeMillis();
        //调用原始方法运行
        Object result = joinPoint.proceed();
        //记录结束时间
        long end = System.currentTimeMillis();
        //输出运行耗时
        log.info(joinPoint.getSignature()+"方法执行耗时：{}ms",end-begin);//joinPoint.getSignature()拿到方法的签名
        //返回回去方法运行结果
        return result;
    }
}
