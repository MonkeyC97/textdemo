package Review.Test.reflect;

/**
 * 取得父类信息
 */
interface IMessage{

}
interface IMessage2{}

class A implements IMessage,IMessage2{

}

public class Test1 {
    public static void main(String[] args) {
        Class<?> cls = A.class;
        //包名
        System.out.println(cls.getPackage().getName());
        //父类名称
        System.out.println(cls.getSuperclass().getName());
        //父接口
        Class<?> [] classes = cls.getInterfaces();
        for(Class<?> a:classes){
            System.out.println(a);
        }
    }
}
