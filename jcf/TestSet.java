package com.monkeyc.jcf;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("PHP");
        set.add("C++");
        set.add("SQL");
        set.add("Python");
        set.add("C");
        set.add("C");
        System.out.println("集合元素个数："+set.size());
        System.out.println("集合是否为空："+set.isEmpty());
        System.out.println("移除SQL："+set.remove("SQL"));
        System.out.println("是否包含Java:"+set.contains("Java"));
        System.out.println(set);
    }
}
