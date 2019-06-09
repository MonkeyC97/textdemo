package com.monkeyc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编程式Lock方法买票
 */

class MyRunnable5 implements Runnable{

    private int tick = 10;
    private Lock tickLock = new ReentrantLock();/** ReentrantLock是一个类，实现了Lock接口和IO包里面的Serializable接口,而Lock接口里面有lock和unlock抽象方法以及其他的抽象方法*/

    @Override
    public void run() {
        while(this.tick > 0){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tickLock.lock();
            try{
                if(this.tick > 0){
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
//        while(this.tick > 0){
//            tickLock.lock();
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            try{
//                if(this.tick > 0 ){
//                    System.out.println(Thread.currentThread().getName() + "买了一张票" + "还剩" + --this.tick + "张票");
//                    if(this.tick == 0){
//                        System.out.println("票买完了");
//                    }
//                }
//            }finally {
//                tickLock.unlock();
//            }
//
//
//        }



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
