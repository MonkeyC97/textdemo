package com.monkeyc.thread;

public class MyRunnable implements Runnable{
    private final String title;

    public MyRunnable(String title) {
        this.title = title;
    }


    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(title+ "i="+i);
        }
    }
}
