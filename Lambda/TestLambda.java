package com.monkeyc.newJava.Lambda;

public class TestLambda {
    public static void main(String[] args) {
        IMessage message =()-> System.out.println("hehe");
        message.print();
    }

    public static void main2(String[] args) {
        IMessage1 message1 = (a,b)->a+b;
        System.out.println(message1.add(10,20));
    }
}
