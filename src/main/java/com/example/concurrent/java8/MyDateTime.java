package com.example.concurrent.java8;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Slf4j
public class MyDateTime {
    public static void main(String[] args) {
        DateTimeFormatter dff = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt = LocalDateTime.now();
        String s1 = dff.format(ldt);
        log.info(" s1 : " + s1);

        DateTimeFormatter dff1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s2 = dff1.format(ldt);
        log.info(" s2 : " + s2);

        LocalDateTime ldt1 = LocalDateTime.parse(s2, dff1);
        log.info(" ldt1 : " + ldt1);
    }
}
