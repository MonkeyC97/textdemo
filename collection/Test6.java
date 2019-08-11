package Review.Test.collection;

import java.util.Set;
import java.util.TreeSet;

class Person1 implements Comparable<Person1>{

    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public Person1(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person1 o) {
        if(this.age > o.age){
            return 1;
        }else if(this.age < o.age){
            return -1;
        }else{
            return this.name.compareTo(o.name);
        }
    }
}

public class Test6 {
    public static void main(String[] args) {
        Set<Person1> set = new TreeSet<>();
        set.add(new Person1("侯昌",22));
        set.add(new Person1("姚怡欢",21));
        set.add(new Person1("王亮棒",22));
        for(Person1 p :set){
            System.out.println(p);
        }
    }
}
