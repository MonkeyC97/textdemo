package Review.Test.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Person4{
    private String name;
    private int age;
    public Person4(){}

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
        return "Person4{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Test7 {
    public static void main(String[] args) {
        Class<?> cls = Person4.class;
        try {
            //任何时候都需要实例化对象来调用类中的普通方法
            Object obj = cls.newInstance();
            Method setMethod = cls.getMethod("setAge", int.class);
            setMethod.invoke(obj,22);
            Method getMethod = cls.getMethod("getAge");
            Object result = getMethod.invoke(obj);
            System.out.println(result);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
