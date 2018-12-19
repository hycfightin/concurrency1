package com.mmall.concurrency;

import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@NotThreadSafe
public class ConcurrencyTest1 {
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

        final Semaphore semaphore = new Semaphore(3);
        //总请求数量 计数器闭锁

        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i =0 ;i < 10; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    //判断当前的线程是否允许被执行
                    semaphore.acquire(2);
                add(threadNum);
                } catch (Exception e) {
                    log.info("fuckyou");
                    log.error("exception" , e);
                }
                semaphore.release(3);
            });
        }
        countDownLatch.await();
        log.info("count:{}",count);
        executorService.shutdown();
    }
    private static void add(int num) throws Exception{
        Thread.sleep(1000);
        log.info("{}",num);

    }

}
