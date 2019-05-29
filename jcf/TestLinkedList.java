package com.monkeyc.jcf;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class TestLinkedList {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("java");
        list.add(0,"PHP");
        list.add("C#");
        list.add("JavaScript");
        list.remove("PHP");
        System.out.println(list);
    }
}
