package Review.Test.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Person{
    String name;
    int age;
    public Person(){

    }
    public Person(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


}

public class Test3 {
    public static void main(String[] args) {
        List<Person> list  = new ArrayList<>();
        list.add(new Person(22,"侯昌"));
        list.add(new Person(22,"侯昌"));
        list.add(new Person(21,"姚怡欢"));
        for(Person p :list){
            System.out.println(p);
        }
        System.out.println(list.contains(new Person(22,"侯昌")));
    }
}
