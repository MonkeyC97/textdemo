package com.leetcode.test;

public class Test7_1 {
    static int x = 100;

    public static void main(String[] args) {
        Test7_1 test7_1 = new Test7_1();
        test7_1.x++;

        Test7_1 test7_2 = new Test7_1();
        test7_2.x++;

        test7_1 = new Test7_1();

        test7_1.x++;

        Test7_1.x--;

        System.out.println(x);
    }
}
