package com.mmall.concurrency.exmple.count;

import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@NotThreadSafe
public class CountExmaple3 {
    //请求总数
    public static int clientTotal = 5000;
    //并发量
    public static  int threadTotal = 200;
    //计数器
    public static  int count = 0;
    public static void main(String[] args) throws  Exception{
        //线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //线程池单次并发量 信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        //总请求数量 计数器闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        CountExmaple3 countExmaple3 = new CountExmaple3();
        for (int i =0 ;i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    //判断当前的线程是否允许被执行
                    semaphore.acquire();
                } catch (Exception e) {
                    log.info("fuckyou");
                    log.error("exception" , e);
                }
                add();
                semaphore.release();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        log.info("count:{}",count);
        executorService.shutdown();
    }
    private synchronized static void add() {

            count++;

    }

}
