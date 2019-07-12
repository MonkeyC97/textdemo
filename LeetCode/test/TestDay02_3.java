package com.leetcode.test;

/**
 * 编译错误，此时声明一个静态变量a不能在方法体内声明
 * 全局变量分为静态变量和成员变量都是在类中，方法体外，静态变量使用static修饰
 * 局部变量在方法体内声明
 */
/*public class TestDay02_3 {
    public int aMethod(){
        static int a = 0;
        a++;
        return a;

    }
    public static void main(String[] args) {
        TestDay02_3 test = new TestDay02_3();
        test.aMethod();
    }
}

*/
