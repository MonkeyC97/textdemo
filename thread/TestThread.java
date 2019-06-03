package com.monkeyc.thread;

public class TestThread {
    public static void main(String[] args) {
        System.out.println("这是main方法的开始");
        MyThread myThread1 = new MyThread("myThread1");
        MyThread myThread2 = new MyThread("myThread2");
        MyThread myThread3 = new MyThread("myThread3");
//        myThread1.run();
//        myThread2.run();
//        myThread3.run();
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread1.start();
        System.out.println("这是main方法的结束");
    }
}
