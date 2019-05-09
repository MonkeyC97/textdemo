package com.monkeyc.github;

public class TestVarArgs {
    public static void main(String[] args) {
//        System.out.println(sum(new int[]{}));//0
//        System.out.println(sum(new int[]{1, 2}));//3
//        System.out.println(sum(new int[]{1, 2, 3}));//6

        System.out.println(sum());//0
        System.out.println(sum(1, 2));//3
        System.out.println(sum(1, 2, 3));//6
        System.out.println(sum(1,2,3,4,5,6));

    }

    //任意的整数求和
//    public static int sum(int a, int b) {
//        return a + b;
//    }
//
//    public static int sum(int a, int b, int c) {
//        return a + b + c;
//    }
    //8个参数 -> new int[]{...}
//    public static int sum(int[] data) {
//        int sum = 0;
//        for (int i = 0; i < data.length; i++) {
//            sum += data[i];
//        }
//        return sum;
//    }

    public static int sum(int... data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }
}
