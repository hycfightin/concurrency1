package com.mmall.concurrency.exmple.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample {
    //修饰代码块  作用于当前的对象，不同的对象之间的调用是并行的 不互相影响的
    public void test( int j) {
        synchronized (this) {
            //同步语句块 作用范围是大括号括起来的部分，作用的对象是调用改代码的对象
            for (int i =0 ; i<10;i++){
                log.info("itest {}  {}",j,i);
            }
        }
    }
    //修饰一个方法 作用于当前的对象，不同的对象之间的调用是并行的 不互相影响的
    //子类继承当前的 方法以后 是不带有 synchronized的
    public synchronized void test2(int j){
        for (int i =0 ; i<10;i++){
            log.info("itest2 {}  {}",j,i);
        }
    }

    public static void main (String args[]){
        SynchronizedExample SynchronizedExample = new SynchronizedExample();
        SynchronizedExample SynchronizedExample2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() ->{
            SynchronizedExample.test2(1);
        });
        executorService.execute(() ->{
            SynchronizedExample2.test2(2);
        });
    }

}
