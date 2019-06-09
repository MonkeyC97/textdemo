package com.monkeyc.thread;

/**
 * 同步方法买票
 */

class MyRunnable4 implements Runnable {

    private  int tick = 10;

    @Override
    public void run() {
        while (tick > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.sale();
        }
    }

    public synchronized void sale() {

            if (this.tick > 0) {
                System.out.println(Thread.currentThread().getName() + "买票" + "还剩下" + --this.tick + "张票");
                if (this.tick == 0) {
                    System.out.println("票卖光了");
                }
            }
        }

}




public class TestTick1{
    public static void main(String[] args) {
     Runnable runnable4 = new MyRunnable4();
     Thread thread1 = new Thread(runnable4,"黄牛A");
     Thread thread2 = new Thread(runnable4,"黄牛B");
//     thread1.setPriority(Thread.MIN_PRIORITY);
//     thread2.setPriority(Thread.MAX_PRIORITY);
     thread1.start();
     thread2.start();
    }
}



