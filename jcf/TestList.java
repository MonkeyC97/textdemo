package com.monkeyc.jcf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TestList {
    public static void main1(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("java");
//      list.add(0,"c++");
        list.add("PHP");
        list.add("PHP");
//        System.out.println(list);
//        System.out.println(list.get(4));
//        System.out.println(list.get(3));
//        System.out.println("元素列表："+list);
//        System.out.println("集合长度："+list.size());
//        System.out.println("集合是否包含PHP"+list.contains("PHP"));
//        System.out.println("移除集合中PHP："+list.remove("PHP"));
//        System.out.println(list);
//        for(int i = 0; i < list.size();i++){
//            System.out.println(list.get(i));
//        }
//        for(String item : list){
//            System.out.println(item);
//        }
        Object[] temp = list.toArray();
//        for(Object object :temp){
//            System.out.println(object);
//        }
        System.out.println(Arrays.toString(temp));
    }

}
