package Review.Test.reflect;


import java.lang.reflect.Field;

/**
 * 动态设置封装
 */
class Person6{
    private String name;

}

public class Test9 {
    public static void main(String[] args) {
        try {
            Class<?> cls = Person6.class;
            Object obj = cls.newInstance();
            Field nameField = cls.getDeclaredField("name");
            //取消封装
            nameField.setAccessible(true);
            nameField.set(obj,"monkeyc");
            System.out.println(nameField.get(obj));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
