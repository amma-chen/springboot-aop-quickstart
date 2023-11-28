package com.itheima.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//描述生效时间，此时为运行时有效
@Target(ElementType.METHOD)
public @interface MyLog {

}
