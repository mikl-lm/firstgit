package com.example.concurrent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test1 {
    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        }
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}

class Annoyance extends Exception {

}
class Sneeze extends Annoyance {

}