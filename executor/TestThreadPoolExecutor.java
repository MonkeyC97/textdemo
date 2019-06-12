package com.monkeyc.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadPoolExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(),
                new ThreadFactory() {
                    final AtomicInteger i = new AtomicInteger();
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("线程"+i.get());
                        return thread;
                    }
                },new ThreadPoolExecutor.DiscardPolicy());
        for(int i = 0;i < 50;i++){
            final int tmp = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+""+"-"+tmp);
                }
            });
        }

    }
}
