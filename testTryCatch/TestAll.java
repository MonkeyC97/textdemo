package com.monkeyc.testTryCatch;

public class TestAll {
    public static void main(String[] args) throws Exception{
        System.out.println(div(10,0));

    }
    public static int div(int a,int b)throws Exception{
        int result = 0;
        try{
            result = a/b;
        }
        finally {
            System.out.println("程序结束");
        }
        return result;
    }
}
