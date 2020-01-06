package com.example.concurrent.designmode;

/**
 * 双重检查锁(DCL)
 * 指令重排: 2,3 -> 3,2
 *  1. 给对象分配内存地址空间
 *  2. 初始化对象
 *  3. 设置对象指向分配的内存
 *
 * 可通过反射和序列化构建类的实例
 */
public class Singleton2 {
    /**
     * volatile 内存屏障防止指令重排
     */
    private volatile static Singleton2 singleton = null;

    private Singleton2() {
    }
    public static Singleton2 instance () {

        if (singleton == null) {
            synchronized (Singleton2.class) {
                if (singleton == null) {
                    singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }
}
