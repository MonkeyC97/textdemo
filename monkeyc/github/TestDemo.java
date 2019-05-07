package com.monkeyc.github;

public class TestDemo {
    public static void main(String[] args) {
        System.out.println(add("hello",1,2,3,4,5,6,7));
        System.out.println(add("hello",1,2,3,4,5));
        System.out.println(add("hello",new int[]{1,2,3,4,5,6,8}));
    }
    public static int add(String msg,int ... data){//如果传递多类参数，可变参数就要放到最后
        int sum = 0;
        for(int i = 0;i <data.length;i++){
            sum += data[i];
        }
        return sum;
    }
}

