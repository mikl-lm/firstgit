package com.example.concurrent.designmode;

import lombok.extern.slf4j.Slf4j;

/**
 * 匿名内部类
 * JVM只加载一次类的实例,先加载外部类,在调用instance() 才会加载内部类的
 */
@Slf4j
public class Singleton4 {

    private Singleton4() {
        log.info("-----------4------------");
    }

    public static Singleton4 instance () {
        log.info("-----------1------------");
        return Singleton.INSTANCE.instanceE();
    }

    private enum Singleton {
        INSTANCE;
        private Singleton4 singleton;
        /**
         * JVM 保证构造只调用一次
         */
        Singleton() {
            log.info("-----------2------------");
            this.singleton = new Singleton4();
        }

        public Singleton4 instanceE () {
            log.info("-----------3------------");
            return singleton;
        }
    }

    public static void main(String[] args) {
        Singleton4.instance();
    }
}
