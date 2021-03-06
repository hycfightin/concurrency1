package com.mmall.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//线程安全的类的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Recommand {
    String value() default "";
}
