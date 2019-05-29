package com.monkeyc.jcf;

import com.monkeyc.io.Person;
import com.sun.tools.classfile.Opcode;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
//        Set<String> set = new TreeSet<>();
//        Set<Integer> set1 = new TreeSet<>();
//        set1.add(69);
//        set1.add(90);
//        set1.add(99);
//        set1.add(42);
//        //已知升序
//        System.out.println(set1);//升序


        //JDK中定义的类的实例化对象在TreeSet 如果改变？
        //TreeSet使用了自定义类型Person，但是排序失败了，可见排序是有要求的
        //1.实现Comparable接口    2.在TreeSet实例化的时候指定一个比较器Comparator
        Set<Person> set = new TreeSet<>(Comparator.comparingInt(o -> o.getName().length()));
        set.add(new Person("hehe",21));
        set.add(new Person("he",22));
        set.add(new Person("wdnmd",23));
        set.add(new Person("monkeyc",24));
        set.add(new Person("haha",25));
        System.out.println(set);
    }
}
