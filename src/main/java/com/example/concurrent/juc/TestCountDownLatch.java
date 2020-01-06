package com.example.concurrent.juc;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TestCountDownLatch {
    public static void main(String[] args) {
        for (int i = 1; i < 3; i++) {
            log.info(CountEnum.getEnum(i).getValue().toString());
        }
    }
    List list = new ArrayList();
}
enum CountEnum {
    HHH(1,"asdadas"),
    MMM(2,"1231232");
    @Getter
    private int key;
    @Getter
    private String value;

    CountEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static CountEnum getEnum (int index) {
        CountEnum[] countEnums = CountEnum.values();
        for (CountEnum c: countEnums) {
            if (c.key == index) {
                return c;
            }
        }
        return null;
    }
}