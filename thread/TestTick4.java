package com.monkeyc.thread;

/**
 * 同步普通对象购票
 */
class MyRunnable7 implements Runnable{
    private int tick = 10;
    Object obj = new Object();
    @Override
    public void run() {

        while(this.tick > 0){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj){
                if(this.tick > 0){
                    System.out.println(Thread.currentThread().getName()+"买了一张票"+"还剩下"+--this.tick+"张票");
                    if(this.tick == 0){
                        System.out.println("票卖完了");
                    }
                }
            }

        }
    }
}

public class TestTick4 {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable7();
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        thread.start();
        thread1.start();
    }
}
