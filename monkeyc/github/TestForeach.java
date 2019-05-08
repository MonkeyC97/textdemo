package com.monkeyc.github;

public class TestForeach {

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5};
        int sum = 0;
        int index = 0;
        for (int datum : data) {
            sum += datum;//不需要通过下标来访问元素
            System.out.println("index=" + index + " value=" + datum);
            index++;
        }
        System.out.println("Sum=" + sum);
    }
}