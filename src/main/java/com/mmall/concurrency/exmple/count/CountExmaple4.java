package com.mmall.concurrency.exmple.count;

import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@NotThreadSafe
public class CountExmaple4 {
    //请求总数
    public static int clientTotal = 5000;
    //并发量
    public static  int threadTotal = 200;
    //计数器
    public static AtomicInteger count = new AtomicInteger();
    public static AtomicInteger count1 = new AtomicInteger();
    public static void main(String[] args) throws  Exception{
        //线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //线程池单次并发量 信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        //总请求数量 计数器闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        CountExmaple4 countExmaple3 = new CountExmaple4();
        for (int i =0 ;i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    //判断当前的线程是否允许被执行
                    semaphore.acquire();
                    log.info("1111111111111111");
                } catch (Exception e) {
                    log.info("fuckyou");
                    log.error("exception" , e);
                }
                add();
                semaphore.release();
                countDownLatch.countDown();
            });
            executorService.execute(() -> {
                try {
                    //判断当前的线程是否允许被执行
                    semaphore.acquire();
                    log.info("22222222222222");
                } catch (Exception e) {
                    log.info("fuckyou");
                    log.error("exception" , e);
                }
                add1();
                semaphore.release();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        log.info("count:{}",count);
        log.info("count:{}",count1);
        executorService.shutdown();
    }
    private synchronized static void add() {

            count.incrementAndGet();

    }
    private synchronized static void add1() {

        count1.incrementAndGet();

    }

}
