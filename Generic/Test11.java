package Review.Test.Generic;

class Person{
    private String name;
    @Deprecated
    public Person(){

    }
    public Person(String name){
        this.name = name;
    }
    @Deprecated
    public void fun(){

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class Test11 {
    public static void main(String[] args) {
        Person person = new Person() ; // 明确的标记出过期
        person.fun();
        person = new Person("hehe") ;
        System.out.println(person);
    }

}
