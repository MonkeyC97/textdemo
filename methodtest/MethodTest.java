package com.monkeyc.generic.methodtest;
@FunctionalInterface
interface IUtil<K,V>{
    public V swithKey(K k);
}
public class MethodTest {
    public static void main(String[] args) {
        IUtil<Integer,String> util = String::valueOf;
        String str = util.swithKey(1000);
        System.out.println(str.length());
    }
}
