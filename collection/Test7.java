package Review.Test.collection;

/**
 * 使用Comparator接口
 */

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Person2{
    private int age;
    private String name;

    public Person2(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class AscAgeComparator implements Comparator<Person2>{


    @Override
    public int compare(Person2 o1, Person2 o2) {
        return o1.getAge() - o2.getAge();
    }
}
class DescAgeComparator implements Comparator<Person2>{

    @Override
    public int compare(Person2 o1, Person2 o2) {
        return o2.getAge() - o1.getAge();
    }
}
public class Test7 {
    public static void main(String[] args) {
        Set<Person2> set = new TreeSet<>(new AscAgeComparator());
        set.add(new Person2(22,"侯昌"));
        set.add(new Person2(21,"姚怡欢"));
            System.out.println(set);
        System.out.println("------------------------------------------------------------");
        Set<Person2> set1 = new TreeSet<>(new DescAgeComparator());
        set1.add(new Person2(23,"王亮"));
        set1.add(new Person2(25,"王凡"));
            System.out.println(set1);
    }
}
