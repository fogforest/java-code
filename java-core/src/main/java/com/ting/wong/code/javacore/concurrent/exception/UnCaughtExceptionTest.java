package com.ting.wong.code.javacore.concurrent.exception;

/**
 * @author Ting Wong
 * @version 1.0
 **/
public class UnCaughtExceptionTest {

    static Thread.UncaughtExceptionHandler handler = (t, e) -> {
        System.out.println("UncaughtExceptionHandler handler Exception");
        e.printStackTrace();
    };

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("before");
            if (true) {
                throw new RuntimeException("just test");
            }
            System.out.println("after");
        });
        t.setUncaughtExceptionHandler(handler);
        t.start();
    }


}
