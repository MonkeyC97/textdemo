package com.monkeyc.thread;
class Sync{
    int tick = 10;
    public void test(){
            while(this.tick > 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(this.tick > 0){
                    synchronized (Sync.class){
                    System.out.println(Thread.currentThread().getName()+"买票"+"还剩下"+--this.tick+"张票");
                    if (this.tick == 0) {
                        System.out.println("票卖光了");
                    }
                }
            }
        }
    }
}
class MyRunnable6 implements Runnable{
    Sync sync = new Sync();
    @Override
    public void run() {
        sync.test();
    }
}


public class TestTick3 {
    public static void main(String[] args) {
        Runnable runnable1 = new MyRunnable6();
        Runnable runnable2 = new MyRunnable6();
        Runnable runnable3 = new MyRunnable6();
            Thread thread1 = new Thread(runnable1);
            Thread thread2 = new Thread(runnable2);
            Thread thread3 = new Thread(runnable3);
            thread1.start();
            thread2.start();
            thread3.start();
    }

}
