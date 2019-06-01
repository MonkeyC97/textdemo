package com.monkeyc.jcf;

import java.util.*;

public class TestCollections {
    //反转
    public static void main1(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"Java","C++","PHP");
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }

    public static void main2(String[] args) {
        List list = Collections.emptyList();
        list.add("Java");
        System.out.println(list.isEmpty());
    }
    //最大数
    public static void main3(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ;i < 10; i ++ ){
            integers.add(random.nextInt(50));
        }
        System.out.println(integers);
        Integer maxValue = Collections.max(integers);
        System.out.println(maxValue);
    }
    //洗牌
    public static void main4(String[] args) {
        List<Integer> integers = new ArrayList<>();
        for(int i = 0; i <= 54;i++){
            integers.add(i);
        }
        System.out.println(integers);
        //洗牌
        Collections.shuffle(integers);
        System.out.println(integers);

        Collections.shuffle(integers);
        System.out.println(integers);
    }

    public static void main(String[] args) {
//        Map<Integer,String> map = new HashMap<>();
//        map.put(1,"666");
        //不可变的
        Map<Integer,String> map = Collections.singletonMap(1,"666");
        System.out.println(map);
        map.put(2,"777");
        System.out.println(map);
    }
}
