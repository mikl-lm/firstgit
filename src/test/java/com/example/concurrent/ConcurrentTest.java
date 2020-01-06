package com.example.concurrent;

import com.example.concurrent.annotation.NotThreadSafe;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@NotThreadSafe
public class ConcurrentTest {

    private static int clientTotal = 5;

    private static int threadTotal = 2;

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();

        executorService.shutdown();

        System.out.println("count -> " + count.get());
    }

    private static void add () {
        count.incrementAndGet();
    }
}
