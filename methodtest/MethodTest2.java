package com.monkeyc.generic.methodtest;
@FunctionalInterface
interface IUtil2<P,R>{
    public R compare(P p1,P p2);
}
public class MethodTest2 {
    public static void main(String[] args) {
        IUtil2<String,Integer> iUtil2 = String::compareTo;
        System.out.println(iUtil2.compare("侯","刘"));
    }
}
