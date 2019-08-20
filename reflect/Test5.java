package Review.Test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 根据Constructor类实例化对象
 */
class Person2{
    String name;
    int age;
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

public class Test5 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> cls  = Person2.class;
        Constructor<?> con = cls.getConstructor(String.class,int.class);
        System.out.println(con.newInstance("monkeyc",22));

    }
}
