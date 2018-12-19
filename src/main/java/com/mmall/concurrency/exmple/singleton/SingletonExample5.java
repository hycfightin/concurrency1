package com.mmall.concurrency.exmple.singleton;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
/**
 * 懒汉模式  单例的实例 在第一次的时候创建
 * 双重同步锁单例模式
 */
public class SingletonExample5 {
    //构造函数私有  这样外面无法通过 new对象来创造新的对象出来
    private SingletonExample5() {

    }
    //单例对象  限制指令重拍  在双重检测的时候用  禁止指令重排
    private volatile static SingletonExample5 instance =null;
    //静态的工厂方法
    public static SingletonExample5 getInstance() {

        if (instance == null){
            //双重检测机制
            synchronized (SingletonExample5.class) {
                //1. memory = allocate（） 分配对象的内存空间
                //2. ctorinstance（） 初始化对象
                //3. instance = memory 设置instance指向刚分配的内存
                //这是一个对象初始化 cpu的过程

                // jvm 和 cpu 优化 导致指令重拍 这样会导致初始化对象和 分配内存空间发生了指令重排序
                //1. memory = allocate（） 分配对象的内存空间
                //3. instance = memory 设置instance指向刚分配的内存
                //2. ctorinstance（） 初始化对象
                if (instance== null){
                    instance = new SingletonExample5();
                }
                instance = new SingletonExample5();
            }
        }
        return instance;
    }
}
