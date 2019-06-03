package com.monkeyc.thread;

public class TestRunnable {
    public static void main1(String[] args) {
        Runnable runnable1 = new MyRunnable("MyRunnable1");
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable1);
        thread1.start();
        thread2.start();
    }

    public static void main2(String[] args) {
        System.out.println("main1");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 10;i++){
                    System.out.println(i);
                }
            }
        });
        thread.start();//start0->jvm->native os
    }

    public static void main(String[] args) {
//        new Thread(()->{
//            for(int i = 0;i < 10;i++){
//                System.out.println("Thread1"+i);
//            }
//        }).start();//匿名对象调用start

        new Thread(()-> System.out.println("Thread")).start();
    }
}
