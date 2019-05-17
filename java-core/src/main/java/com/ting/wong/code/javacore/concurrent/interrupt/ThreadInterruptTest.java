package com.ting.wong.code.javacore.concurrent.interrupt;

/**
 * @author Ting Wong
 * @version 1.0
 **/
public class ThreadInterruptTest extends Thread{

    @Override
    public void run() {
        try {
            //true
            System.out.println("ThreadInterruptTest:"+Thread.currentThread().isInterrupted());
            //不会sleep，清除状态，并置为false
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            //抛出异常后线程的interrupt状态置为false
            System.out.println("ThreadInterruptTest,exception:"+Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadInterruptTest tt = new ThreadInterruptTest();
        tt.start();
        System.out.println("main first:"+tt.isInterrupted());
        //将线程的interrupt状态置为true
        //Thread.sleep(1000);
        tt.interrupt();
        System.out.println("main after:"+tt.isInterrupted());
    }

}
