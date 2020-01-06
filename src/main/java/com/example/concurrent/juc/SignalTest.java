package com.example.concurrent.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
@Slf4j
public class SignalTest {

    public static void main(String[] args) {
        final String str = "wqeq";
        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService executor = new ThreadPoolExecutor(
                3,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < 10; i++) {
            int temp = i;
            executor.execute(() -> {
                System.out.println("----------------> " + Thread.currentThread().getName() + " ----> " + temp);
            });
        }

        /* ShareDate shareDate = new ShareDate();
        executor.execute(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareDate.getIncrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        executor.execute(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareDate.getDecrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }); */
        executor.shutdown();
    }

}
class ShareDate {
    //private int number = 0;
    private AtomicInteger number = new AtomicInteger();
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void getIncrement (){
        lock.lock();
        try{
            while (number.get() != 0) {
                condition.await();
            }
            number.getAndIncrement();
            System.out.println("============1>" + Thread.currentThread().getName() + "------> " + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void getDecrement () {
        lock.lock();
        try {
            while (number.get() == 0) {
                condition.await();
            }
            number.getAndDecrement();
            System.out.println("============2>" + Thread.currentThread().getName() + "------> " + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}