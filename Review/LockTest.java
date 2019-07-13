package Review;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Task implements Runnable{
    private  Lock lock = new ReentrantLock();

    @Override
    public void run() {
        boolean  isLock = false;
        try {
            if (lock.tryLock(2,TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getName()+"获取锁成功");
                TimeUnit.SECONDS.sleep(3);
                isLock = true;
            }else{
                System.out.println(Thread.currentThread().getName()+"获取锁失败");
            }
//            while(true){
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    System.out.println("线程中断");
//                    e.printStackTrace();
//                    return;
//                }
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (isLock){
                lock.unlock();
                System.out.println("锁已释放");
            }
        }
    }
}

public class LockTest {
    public static void main1(String[] args) {
        Object o = new Object();
        Thread thread = new Thread(()->{
            while(true){
                synchronized (o){
                    //不响应中断
                }
            }

        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("线程终止");
//        //只是将线程的状态置为interrupt
//        if(thread.isInterrupted()){
//
//        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task,"线程1");
        Thread thread1 = new Thread(task,"线程2");
        thread.start();
        thread1.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
