package com.mmall.concurrency.exmple.commomUnsafe;

import java.text.SimpleDateFormat;
import java.util.concurrent.*;

public class DateFormatExample1 {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    public static void main(String[] args) {
        //开启一个新的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //单次 并发的信号量
        final Semaphore semaphore = new Semaphore(200);
        //总请求数量 计数器闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(5000);

        for (int i = 0; i<=5000 ;i++) {
            executorService.execute(() -> {
                semaphore.release();
            });
        }

    }


}
