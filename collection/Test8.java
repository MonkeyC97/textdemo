package Review.Test.collection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * 覆写hashCode()与equals()方法消除重复
 */

class Person3 implements Comparable<Person3>{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public Person3(String name,int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person3 person3 = (Person3) o;
        return age == person3.age &&
                Objects.equals(name, person3.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person3 o) {
        if(this.age > o.age){
            return 1;
        }else if(this.age < o.age){
            return -1;
        }
        else{
            return this.name.compareTo(o.name);
        }
    }
}

public class Test8 {
    public static void main(String[] args) {
        Set<Person3> set = new HashSet<>();
        set.add(new Person3("houchang",23));
        set.add(new Person3("houchang",23));
        set.add(new Person3("monkeyc",23));
        set.add(new Person3("qiaobiluo",58));
        for(Person3 p :set){
            System.out.println(p);
        }
    }
}
