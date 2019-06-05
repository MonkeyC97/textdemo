package com.monkeyc.generic.methodtest;
@FunctionalInterface
interface IUtil1<T>{
    public T switchPara();
}
public class MethodTest1 {
    public static void main(String[] args) {
        IUtil1<String> util1 = "helloworld"::toUpperCase;
        System.out.println(util1.switchPara());
    }
}
