package com.monkeyc.singleton;
/*
饿汉单例模式
 */
class SingleTon1{
    private final static SingleTon1 instance = new SingleTon1();

    private SingleTon1(){

    }
    public static SingleTon1 getInstance(){
        return instance;
    }
    public void print(){
        System.out.println("hehe");
    }
}
public class HungrySingleTon {
    public static void main(String[] args) {
        SingleTon1 singleTon1 = SingleTon1.getInstance();
        singleTon1.print();
    }
}
