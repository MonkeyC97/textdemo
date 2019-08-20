package Review.Test.reflect;


import java.lang.reflect.Field;

/**
 * 取得类中所有的属性
 */

class Person5{
    public   int age;
    public String name;
}
class Student extends  Person5{
    private String school;
}
public class Test8 {
    public static void main(String[] args) {
        Class<?> cls = Student.class;
        {
            Field[] fields = cls.getFields();
            for(Field fid : fields){
                System.out.println(fid);
            }
        }
        System.out.println("--------------------");
        {
            //本类中全部的属性
            Field[] fields = cls.getDeclaredFields();
            for(Field fid1 : fields){
                System.out.println(fid1);
            }
        }
    }
}
