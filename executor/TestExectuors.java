package com.monkeyc.executor;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExectuors {
    public static void main(String[] args) {
        //固定线程数
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //单线程
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //无限限制线程数
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 5;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+""+ LocalDateTime.now().toString());
            });
        }
    }
}
