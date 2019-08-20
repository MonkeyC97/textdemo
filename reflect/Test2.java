package Review.Test.reflect;

/**
 * 取得了了Class对象就意味着取得了了⼀一个指定类的操作权
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            Class cls = Class.forName("java.util.Date");
            Object obj = cls.newInstance();
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
