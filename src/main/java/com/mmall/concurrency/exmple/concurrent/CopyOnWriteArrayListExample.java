package com.mmall.concurrency.exmple.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
@Slf4j
public class CopyOnWriteArrayListExample {
    public static int clientTotal = 5000;
    public  static int threadTotal = 200;
    private  static List<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i =1;i<clientTotal;i++) {
            final int count = i;
            executorService.execute(()-> {
                        try {
                            semaphore.acquire();
                            upadte(count);
                            semaphore.release();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        countDownLatch.countDown();
                    });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        log.info("SIZE{}",list.size());
    }
    private static void upadte (int count) {list.add(count);}
}
