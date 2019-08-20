package Review.Test.reflect;

import com.monkeyc.generic.Enum.Enum;

import java.lang.reflect.Constructor;

class Person{
    public Person(){

    }
    public Person(String name,int age){}

    public Person(String name, int age, Enum sex){

    }
}

public class Test3 {
    public static void main(String[] args) {
       Class<?> cls = Person.class;
        Constructor<?>[]  constructors = cls.getConstructors();
        for(Constructor<?> constructor : constructors){
            System.out.println(constructor);
        }
        cls.getInterfaces();
    }
}
