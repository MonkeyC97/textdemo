package com.monkeyc.jcf;

import java.util.Hashtable;

public class TestHashtable {
    public static void main(String[] args) {
        Hashtable<String,String> hashtable = new Hashtable<>();
        hashtable.put("1","Java");
        hashtable.put(null,"PHP");//key不能为null，源码不判断NullPointException
        hashtable.put("2",null);//value不能为null，源码判断NullPointException
    }
}
