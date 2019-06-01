package com.monkeyc.jcf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("R");
        list.add("VB");
        list.add("PHP");
        list.add("Golang");
        list.add("F#");
        list.add("SQL");
        list.add("Groovy");
        list.add("Kotlin");
        list.add("Scala");
        list.add("Rust");
        list.add("Javascript");
        list.add("C++");
        list.add("C");
        list.add("C#");

        list.forEach(System.out::println);

        System.out.println(list.size());
        System.out.println(list.stream().count());

        System.out.println(list.stream().filter(s->s.contains("Java")||(s.contains("C"))).collect(Collectors.toList()));


        System.out.println(list.stream().map(s->s.toLowerCase()).filter(s->s.contains("c")).filter(s->s.length()>2).collect(Collectors.toList()));


        System.out.println(list.stream().filter(s->s.contains("C")).skip(1).limit(2).collect(Collectors.toList()));

    }

}
