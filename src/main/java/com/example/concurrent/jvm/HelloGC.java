package com.example.concurrent.jvm;

public class HelloGC {
    public static void main(String[] args) {
        System.out.println("================HelloGC==============");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
