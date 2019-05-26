package com.monkeyc.singleton;
class SingleTon{
    private static SingleTon instance;
    private SingleTon(){}
    public static SingleTon getInstance() {
        if(instance == null){
           instance = new SingleTon();//表示此时还没有实例化
        }
        return instance;
    }
    public void print(){
        System.out.println("hehe");
    }
}
public class LazySIngleTon {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        singleTon.print();
    }
}
