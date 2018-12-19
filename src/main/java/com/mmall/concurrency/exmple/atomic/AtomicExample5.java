package com.mmall.concurrency.exmple.atomic;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ThreadSafe
public class AtomicExample5 {
        private static AtomicIntegerFieldUpdater<AtomicExample5> upadter = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");
        @Getter
        private volatile int count = 100;
        private static  AtomicExample5 atomicExample5 = new AtomicExample5();

        public static void main ( String args[]) {
            if (upadter.compareAndSet(atomicExample5,100,120)){
                log.info("upadte success,{}",atomicExample5.getCount());
            }
            if (upadter.compareAndSet(atomicExample5,100,120)){
                log.info("upadte success,{}",atomicExample5.getCount());
            }else {
                log.info("upadte nope,{}",atomicExample5.getCount());
            }
        }


}
