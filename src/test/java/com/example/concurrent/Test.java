package com.example.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Test {
    private static AtomicInteger s = new AtomicInteger(0);

    public static String reverse(String originStr) {
        s.incrementAndGet();
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        log.info(originStr.substring(1) + " , " + String.valueOf(originStr.charAt(0)));

        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverse("qwerty"));
        System.out.println(s.get());
    }
}
