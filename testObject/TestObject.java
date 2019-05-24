package com.monkeyc.testObject;
class Person{}
class Student{}
public class TestObject {
    public static void main(String[] args) {
        fun(new Person());
        fun(new Student());
    }
    public static  void fun(Object object){
        System.out.println(object);
    }
}
