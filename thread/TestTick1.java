package com.monkeyc.thread;

class MyRunnable4 implements Runnable {

    private int tick = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.sale();
        }
    }

    public synchronized void sale() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(this.tick > 0){
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
     Thread thread1 = new Thread(runnable4);
     Thread thread2 = new Thread(runnable4);
//     thread1.setPriority(Thread.MIN_PRIORITY);
//     thread2.setPriority(Thread.MAX_PRIORITY);
     thread1.start();
     thread2.start();
    }
}



