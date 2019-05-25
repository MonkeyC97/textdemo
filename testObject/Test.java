package com.monkeyc.testObject;

class Person1{
    private String name;
    private int age;
    public Person1(String name,int age){
        this.age = age;
        this.name = name;
    }

    public String toString(){
        return "name:"+this.name+"   age:"+this.age;
    }
}
class student1{}
public class Test {
    public static void main(String[] args) {
        fun(new Person1("monk",18));
        fun("monkeyc");
    }
    public static void fun(Object obj){
        System.out.println(obj.toString());
    }
}
