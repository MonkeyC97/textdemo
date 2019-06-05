package com.monkeyc.testTryCatch;
/**
使用throws关键字声明异常
 */

public class Test1{
    public static int div(int a,int b){
        return a/b;
    }
    public static void main1(String[] args) {
        try{
            System.out.println(div(10,0));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //Exception in thread "main" java.lang.ArithmeticException: / by zero异常
    //第二种方法
    public static void main(String args[]) throws Exception{
        System.out.println(10/0);
    }

}