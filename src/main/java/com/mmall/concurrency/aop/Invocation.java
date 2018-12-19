package com.mmall.concurrency.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invocation {
    private Object [] params;
    private Method method;
    private Object target;

    //构造方法
    public Invocation(Object target,Method method,Object [] params) {
        this.target = target;
        this.method = method;
        this.params = params;
    }

    //反射方法
    public Object proceed() throws InvocationTargetException ,IllegalAccessException {
        return method.invoke(target,params);
    }


}
