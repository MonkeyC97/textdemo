package com.monkeyc.testTryCatch;

public class TestTry {
    public static void main(String[] args) {
        System.out.println("数学计算之前");
        try {
            System.out.println(10/0);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }finally {
            System.out.println("不管是否出现异常都会执行finally");
        }
        System.out.println("数学计算之后");
    }
}
