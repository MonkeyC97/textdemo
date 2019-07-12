package com.leetcode.test;

class A{
    A(){
        System.out.println("AAA");
    }
}

public class TestDay02_2 extends A{
    public static void main(String[] args) {
        new A();
        new TestDay02_2();
    }
}
