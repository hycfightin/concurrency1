package com.mmall.concurrency.exmple.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {
    //修饰一个类
    public static void test( int j) {
        synchronized (SynchronizedExample1.class) {
            //同步语句块 作用范围是大括号括起来的部分，作用的对象是调用改代码的对象
            for (int i =0 ; i<10;i++){
                log.info("itest {}  {}",j,i);
            }
        }
    }
    //修饰一个静态方法 作用域为整个的对象  相同的对象调用这个方法 同一时间只能有一个执行
    //子类继承当前的 方法以后 是不带有 synchronized的
    public static synchronized void test2(int j){
        for (int i =0 ; i<10;i++){
            log.info("itest2  {} {}",j,i);
        }
    }

    public static void main (String args[]){
        SynchronizedExample1 SynchronizedExample = new SynchronizedExample1();
        SynchronizedExample1 SynchronizedExample2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() ->{
            SynchronizedExample.test2(1);
        });
        executorService.execute(() ->{
            SynchronizedExample2.test2(2);
        });
    }

}
