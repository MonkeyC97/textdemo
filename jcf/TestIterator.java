package com.monkeyc.jcf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("C++");
        list.add("C");
//        System.out.println(list);
//        Iterator<String> iterator = list.iterator();
//        while(iterator.hasNext()){
////            System.out.println(iterator.next());
//            String str = iterator.next();
//            iterator.remove();
//        }
//        System.out.println(list);
        //线程不安全,并发修改异常
//        for(String i : list){
//            System.out.println(i);
//            list.remove(i);
//        }
//        while(iterator.hasNext()){
//            String msg = iterator.next();
//            if("Java".equals(msg)){
//                iterator.remove();
//            }
//        }
//        System.out.println(list);

        //从前往后
        System.out.println("从前往后");
        ListIterator<String> iterator = list.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //从后往前
        System.out.println("从后往前");
        while(iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
    }
}
