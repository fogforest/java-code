package com.ting.wong.code.javacore.concurrent.interrupt;

/**
 * @author Ting Wong
 * @version 1.0
 **/
public class InterruptExample {

    //根据isInterrupted控制是否运行
    static Runnable r1 = () -> {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("r1 do something ");
        }
        System.out.println("r1 end ");
    };

    //依赖sleep方法特性控制是否运行
    static Runnable r2 = () -> {
        try {
            System.out.println("r2 do something ");
            //对置为Interrupted的线程调用sleep，不会sleep，清除状态，Interrupted置为false，抛出异常，所以不需要检查是否Interrupted
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("r2 was Interrupted");
        } finally {
            System.out.println("r2 clean up");
        }
        System.out.println("r2 end ");
    };

    //线程不能被中断
    static Runnable r3 = () -> {
        try {
            System.out.println("r3 do something ");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //InterruptedException 异常会把interrupt置为false
            //告诉调用线程，已经收到中断信号了。貌似不生效，interrupt状态并没有变为true？
            Thread.currentThread().interrupt();
            System.out.println("r3 isInterrupted:"+Thread.currentThread().isInterrupted());
        } finally {
            System.out.println("r3 clean up");
        }
        System.out.println("r3 end ");
    };

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(r1);
        t1.start();
        Thread.sleep(1);
        t1.interrupt();
        Thread t2 = new Thread(r2);
        t2.start();
        t2.interrupt();
        Thread.sleep(100);
        System.out.println("t2 isInterrupted:"+t2.isInterrupted());
        Thread t3 = new Thread(r3);
        t3.start();
        t3.interrupt();
        Thread.sleep(100);
        System.out.println("t3 isInterrupted:"+t3.isInterrupted());
    }

}
