package Review.Test.reflect;

import java.lang.reflect.Method;

/**
 * 通过反射取得普通方法
 */
class Person3{
    private String name;
    private int age;

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
    public String toString() {
        return "Person3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void sayHello(){
        System.out.println("hello");
    }
    public Person3(){}

    public void eat(){
        System.out.println("eating");
    }
}



public class Test6 {
    public static void main(String[] args) {
        Class<?> cls = Person3.class;
        Method[] methods = cls.getMethods();
        for(Method met :methods){
            System.out.println(met);
        }
    }
}
