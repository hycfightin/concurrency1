package com.mmall.concurrency.exmple.atomic;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@ThreadSafe
public class AtomicExample {
    //请求总数
    public static int clientTotal = 5000;
    //并发量
    public static  int threadTotal = 200;
    //计数器
    //cas死循环实现  去不断地 对比 当前线程操作的值 与底层的对应的值 是否相等 修改量太多 效率低
    public static AtomicLong count = new AtomicLong (0);
    public static void main(String[] args) throws  Exception{
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
                add();
                semaphore.release();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        log.info("count:{}",count.get());
        executorService.shutdown();
    }
    private static void add() {
        count.incrementAndGet();
        //count.getAndAccumulate();
    }
}
