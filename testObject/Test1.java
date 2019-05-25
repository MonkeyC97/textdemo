package com.monkeyc.testObject;

class Person2{
    private String name;
    private int age;
    public Person2(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Test1 {
    public static void main(String[] args) {
        String msg = "monk"+ new Person2("keyc",22);
        System.out.println(msg);
        fun(msg);
    }
    public static void fun(Object obj){
        System.out.println(obj.toString());
    }
}
