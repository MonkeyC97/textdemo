package Review.Test.reflect;

import java.util.Date;

/**
 * 获取class对象
 */

public class Test {
    public static void main(String[] args) {
        Date date  = new Date();
        System.out.println(date.getClass());
        System.out.println(Date.class);
        try {
            System.out.println(Class.forName("java.util.Date"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
