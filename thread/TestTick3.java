package com.monkeyc.thread;

/**
 * 同步class对象
 */
//class Sync{
//    int tick = 10;
//    public void test(){
//        synchronized (Sync.class) {
//                if (this.tick > 0) {
//                    System.out.println(Thread.currentThread().getName() + "买票" + "还剩下" + --this.tick + "张票");
//                    if (this.tick == 0) {
//                        System.out.println("票卖光了");
//                    }
//                }
//
//        }
//    }
//}
//class MyRunnable6 implements Runnable{
//    private Sync sync;
//    public MyRunnable6(Sync sync){
//        this.sync = sync;
//    }
//    @Override
//    public void run() {
//        for(int i = 0; i < 10;i++) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            sync.test();
//        }
//    }
//}
class Sync{
    private int tick = 10;
    public void test(){
        while(this.tick > 0){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Sync.class){
                if(this.tick > 0){
                    System.out.println(Thread.currentThread().getName()+ "买了一张票"+"还剩下"+--this.tick+"张票");
                    if(this.tick == 0){
                        System.out.println("票卖光了");
                    }
                }
            }

        }
    }
}

class MyRunnable6 implements Runnable{
    private Sync sync;
    public MyRunnable6(Sync sync){
        this.sync = sync;
    }
    @Override
    public void run() {

        sync.test();
    }
}

public class TestTick3 {
    public static void main(String[] args) {
        Sync sync = new Sync();
        Runnable runnable1 = new MyRunnable6(sync);
        Runnable runnable2 = new MyRunnable6(sync);
        Runnable runnable3 = new MyRunnable6(sync);
            Thread thread1 = new Thread(runnable1);
            Thread thread2 = new Thread(runnable2);
            Thread thread3 = new Thread(runnable3);
            thread1.start();
            thread2.start();
            thread3.start();
    }

}
