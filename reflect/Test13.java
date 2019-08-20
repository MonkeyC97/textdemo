package Review.Test.reflect;

/**
 * 自定义类加载器
 */
class Member1{
    @Override
    public String toString(){
        return "Member1";
    }
}

public class Test13{
    public static void main(String[] args) throws Exception{
        Class<?> cls = Member1.class;
        System.out.println(cls.getClassLoader().loadClass("Member1").newInstance());
    }
}