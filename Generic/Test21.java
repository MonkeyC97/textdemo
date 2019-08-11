package Review.Test.Generic;

class Person2{
    String name;
    int age;
    public Person2(){

    }
    public Person2(String name,int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
@FunctionalInterface
interface IMyPerson<R,PN,PA>{
    R message(PN name,PA age);
}

public class Test21 {
    public static void main(String[] args) {
        IMyPerson<Person2,String,Integer> myPerson = Person2::new;
        System.out.println(myPerson.message("monkeyc97",21));
    }
}
