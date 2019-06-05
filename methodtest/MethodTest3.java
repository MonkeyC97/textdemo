package com.monkeyc.generic.methodtest;

class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.age = age;
        this.name = name;
    }
    public String toString(){
        return "name="+this.name+"\n"+"age="+this.age;
    }

}


interface IUtil3<R,PN,PA>{
    R createPerson(PN pn,PA pa);
}

public class MethodTest3 {
    public static void main(String[] args) {
        IUtil3<Person,String,Integer> iUtil3 = Person::new;
        System.out.println(iUtil3.createPerson("hehe",19));
    }
}
