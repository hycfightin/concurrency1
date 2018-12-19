package com.mmall.concurrency.exmple.singleton;

import com.mmall.concurrency.annoations.Recommand;
import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
@Recommand
/**
 * 线程最安全
 */
public class SingletonExample7 {
    private  SingletonExample7(){

    }
    public static  SingletonExample7 getInstance() {
        return  Singleton.INSTANCE.getInstance();
    }

    private  enum  Singleton {
        INSTANCE;
        private SingletonExample7 singleton;
        //jvm保证这个方法只会被调用一次
        Singleton (){
            singleton = new SingletonExample7();
        }
        public SingletonExample7 getInstance(){
            return singleton;
        }
    }
}
