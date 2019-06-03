package com.monkeyc.thread;

 class MyThread extends Thread {

     private final String title;

     public MyThread(String title) {
         this.title = title;
     }

     @Override
     public void run() {
         for (int i = 0; i <11 ; i++) {
             System.out.println(this.title+" " +"i="+i);
         }
     }
 }
