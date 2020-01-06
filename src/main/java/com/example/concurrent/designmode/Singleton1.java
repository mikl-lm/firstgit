package com.example.concurrent.designmode;

/**
 * 恶汉模式
 */
public class Singleton1 {
    private static Singleton1 singleton = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 instance () {
        return singleton;
    }
}
