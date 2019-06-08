package com.monkeyc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyRunnable5 implements Runnable{

    private int tick = 10;
    private Lock tickLock = new ReentrantLock();

    @Override
    public void run() {
        for(int i = 0 ; i < 10;i--){
            tickLock.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try{

                if(this.tick > 0) {
                    System.out.println(Thread.currentThread().getName() + "买了一张票" + "还剩" + --this.tick + "张票");
                    if(this.tick == 0){
                        System.out.println("票卖光了");
                    }
                }
            }finally {
                tickLock.unlock();
            }
        }
    }
}
public class TestTick2 {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable5();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
    }

}
