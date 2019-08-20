package Review.Test.reflect;

/**
 * 初识ClassLoader
 */
class Member{

}
public class Test12 {
    public static void main(String[] args) {
        Class<?> cls = Member.class;
        System.out.println(cls.getClassLoader());
        System.out.println(cls.getClassLoader().getParent());
        System.out.println(cls.getClassLoader().getParent().getParent());
    }
}
