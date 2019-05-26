package com.monkeyc.testObject;

import java.util.Arrays;

//Object接受数组对象
public class Test3{
    public static void main(String[] args) {
        Object obj = new int[]{1,2,3,4,5,6};
        int[] data = (int[]) obj;
        for(int i :data){
            System.out.println(i);
        }
    }
}
