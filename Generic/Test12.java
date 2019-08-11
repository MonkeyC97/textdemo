package Review.Test.Generic;

class Person1{
    @Deprecated
    public Person1(){

    }
    public Person1(String name){

    }
}

public class Test12 {
    public static void main(String[] args) {
        @SuppressWarnings({"rawtypes","unused"})//压制警告
                Person1 person1 = new Person1();
    }
}
