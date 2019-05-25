package com.monkeyc.testObject;

import java.util.Objects;

class Person3{
    private String name;
    private int age;
    public Person3(String name,int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person3 person3 = (Person3) o;
        return age == person3.age &&
                name.equals(person3.name);
    }

}
public class Test2 {
    public static void main(String[] args) {
        Person3 monkeyc = new Person3("monkeyc97",22);
        Person3 monkeyc97 = new Person3("monkeyc97",22);
        System.out.println(monkeyc.equals(monkeyc97));
    }
}
