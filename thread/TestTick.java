package com.monkeyc.thread;

/**
同步当前对象(this)对象买票
 */

class MyRunnable3 implements  Runnable{
    int tick = 10;
    @Override
    public void run() {
        while(tick > 0){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this){
                if(this.tick > 0){
                    System.out.println(Thread.currentThread().getName()+"买了一张票"+"还剩下"+--this.tick+"张票");
                    if(this.tick == 0){
                        System.out.println("票卖光了");
                    }
                }
            }
        }
    }
}
public class TestTick {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable3();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
