package com.monkeyc.jcf;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Java");
        map.put(2,"C");
        map.put(3,"Python");
        map.put(4,"C++");
        map.put(5,"null");
        map.put(6,"Python");
        map.put(1,"PHP");
        map.put(null,"SQL");
        System.out.println(map);
        /*
            1. key 可以为null但是不能重复
            2. value 可以为null可以重复
         */
        System.out.println("元素的个数："+map.size());
        System.out.println("元素的所有key："+map.keySet());
        System.out.println("集合元素的所有value："+map.values());
        System.out.println("集合元素是否为空："+map.isEmpty());
        System.out.println("获取key = null 的 value："+map.get(null));
        System.out.println("获取key = 9 的value："+map.get(9));
        System.out.println("集合是否包含key = 12："+ map.containsKey(12));

        //1遍历map
        //1.keyset 2. key -> value
        for(Integer key : map.keySet()){
            System.out.println(map.get(key));
        }

        //2遍历map
        for(String value : map.values()){
            System.out.println(value);
        }

        //3entrySet
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        for(Map.Entry<Integer,String> entry : set){
            System.out.println(entry.getKey() + "=" +entry.getValue());
        }
    }
}
