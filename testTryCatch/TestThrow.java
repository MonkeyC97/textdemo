package com.monkeyc.testTryCatch;

public class TestThrow{
    public static void main(String[] args) {
        try{
            throw new Exception("抛出异常");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
