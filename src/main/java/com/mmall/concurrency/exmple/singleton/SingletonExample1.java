package com.mmall.concurrency.exmple.singleton;

import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
/**
 * 懒汉模式  单例的实例 在第一次的时候创建
 */
public class SingletonExample1 {
    //构造函数私有  这样外面无法通过 new对象来创造新的对象出来
    private SingletonExample1() {

    }
    //单例对象
    private static SingletonExample1 instance =null;
    //静态的工厂方法
    public SingletonExample1 getInstance() {
        //在单线程下是没有问题的 但是在多线程的情况之下  可能会出现 多个线程同时初始化这个对象的时候
        if (instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
