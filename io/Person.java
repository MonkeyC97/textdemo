package com.monkeyc.io;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class Person implements Serializable,Comparable<Person>{
    private String name;
    private Integer age;
    private String[] getSkills;
    private Date birthday;
    public Person(){}
    public Person(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getGetSkills() {
        return getSkills;
    }

    public void setGetSkills(String[] getSkills) {
        this.getSkills = getSkills;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", getSkills=" + Arrays.toString(getSkills) +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        //策略（按对象的哪个集体属性做比较）
//        return this.age - o.getAge();
        int a = this.age;
        int b = o.getAge();
        return a < b ? -1 : (a - b);

    }
}
