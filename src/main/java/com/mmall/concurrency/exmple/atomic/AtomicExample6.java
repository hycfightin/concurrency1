package com.mmall.concurrency.exmple.atomic;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@ThreadSafe
//在线程中 某一段代码只执行一遍
public class AtomicExample6 {
        private static AtomicBoolean isHappend = new AtomicBoolean(false);
    //请求总数
    public static int clientTotal = 5000;
    //并发量
    public static  int threadTotal = 200;
    //计数器
    public static AtomicLong count = new AtomicLong (0);

        public static void main ( String args[])  throws Exception{
            //线程池
            ExecutorService executorService = Executors.newCachedThreadPool();
            //线程池单次并发量 信号量
            final Semaphore semaphore = new Semaphore(threadTotal);
            //总请求数量 计数器闭锁
            final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
            for (int i =0 ;i < clientTotal; i++) {
                executorService.execute(() -> {
                    try {
                        //判断当前的线程是否允许被执行
                        semaphore.acquire();
                    } catch (Exception e) {
                        log.info("fuckyou");
                        log.error("exception" , e);
                    }
                    test();
                    semaphore.release();
                    countDownLatch.countDown();
                });
            }
            countDownLatch.await();
            log.info("isHappend:{}",isHappend.get());
            executorService.shutdown();
        }

        private static void test () {
            if (isHappend.compareAndSet(false,true)) {
                log.info("execute");
            }
        }


}
