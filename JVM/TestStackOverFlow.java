package com.monkeyc.JVM;

/**
 * StackOverFlow异常（单线程情况下）
 */
public class TestStackOverFlow {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        TestStackOverFlow stack = new TestStackOverFlow();
        try{
            stack.stackLeak();
        }catch (Throwable e){
            System.out.println("Stack Length:"+stack.stackLength);
            throw e;
        }
    }
}
