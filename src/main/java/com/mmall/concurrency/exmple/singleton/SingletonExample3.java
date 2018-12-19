package com.mmall.concurrency.exmple.singleton;

import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
/**
 * 懒汉模式  单例的实例 在第一次的时候创建
 */
public class SingletonExample3 {
    //构造函数私有  这样外面无法通过 new对象来创造新的对象出来
    private SingletonExample3() {

    }
    //单例对象
    private static SingletonExample3 instance =null;
    //静态的工厂方法
    // 线程安全了  不过性能不高
    public static synchronized SingletonExample3 getInstance() {

        if (instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
