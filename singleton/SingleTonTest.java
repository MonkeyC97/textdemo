package com.monkeyc.singleton;
class Singleton{
    private static Singleton instance = new Singleton();
    private Singleton(){}
    public void print(){
        System.out.println("hehe");
    }
    public static Singleton getInstance(){
        return instance;
    }
}
public class SingleTonTest {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.print();
    }
}
