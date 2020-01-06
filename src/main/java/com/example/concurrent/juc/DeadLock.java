package com.example.concurrent.juc;

public class DeadLock {
    public static void main(String[] args) {
         String lockA = "AAA";
         String lockB = "BBB";

         new Thread(new MyThread(lockA,lockB),"Thread-AAA").start();
         new Thread(new MyThread(lockB,lockA),"Thread-BBB").start();
    }
}

class MyThread implements Runnable {
    private String lockA;
    private String lockB;

    public MyThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + " 持有锁 "+ lockA +" ,尝试获取 " + lockB);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + " 持有锁 "+ lockB +" ,尝试获取 " + lockA);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}