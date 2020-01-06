package com.example.concurrent.designmode;

import lombok.extern.slf4j.Slf4j;

/**
 * 匿名内部类
 * JVM只加载一次类的实例,先加载外部类,在调用instance() 才会加载内部类的
 */
@Slf4j
public class Singleton3 {

    private Singleton3() {
    }

    private static class InstanceFactory {
        private static Singleton3 singleton = new Singleton3();
    }

    public static Singleton3 instance () {
        return InstanceFactory.singleton;
    }

    public static void main(String[] args) {
        Singleton3.instance();
    }
}
