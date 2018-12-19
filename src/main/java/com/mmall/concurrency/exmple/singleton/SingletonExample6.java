package com.mmall.concurrency.exmple.singleton;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
/**
 * 饿汉模式  在类进行装载的时候进行创建
 */
public class SingletonExample6 {
    //构造函数私有  这样外面无法通过 new对象来创造新的对象出来
    private SingletonExample6() {

    }
    //单例对象
    private static SingletonExample6 instance =null;
    //写静态域和静态变量的时候要注意他们写的顺序
    static {
        instance = new SingletonExample6();
    }

    //静态的工厂方法
    public static SingletonExample6 getInstance() {
        //线程安全的  在类的构造方法中没有包含过多的处理 那么这个是没问题的，处理复杂的话可能会影响性能
        //如果只进行类的加载 而不进行类的操作的话  会造成资源的浪费
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
