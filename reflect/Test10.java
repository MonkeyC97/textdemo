package Review.Test.reflect;

import java.lang.reflect.Field;

/**
 * getType()
 */
class Person7{
    private int age;
    private String name;
}

public class Test10 {
    public static void main(String[] args) {
        Class<?> cls = Person7.class;
        try {
            Object obj = cls.newInstance();
            Field field = cls.getDeclaredField("name");
            System.out.println(field.getType().getName());
            System.out.println(field.getType().getSimpleName());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
