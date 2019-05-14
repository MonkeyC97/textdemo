package com.monkeyc.reflect;
import java.util.Date;

public class TestReflect {
    public static void main1(String[] args) {
        Date date = new Date();
        //小写class是一个关键字
        //大写Class 是一个类型
        //Java 类 extends Object
        //Object 类中 getClass()返回一个Class类型的对象
        //Class：是一个类型
        //类是对现实事物的一个抽象
        //对象是现实的具体事物(你所关注的事物对象)
        Class  aClass = date.getClass();
        System.out.println(aClass);
        //如果date是Date类，返回true 否则返回false
        System.out.println(date instanceof Date);
        Class classz = Date.class;//返回Date类的Class对象
        System.out.println(classz);

        //className ==》全线类名
        try {
           Class classzz =  Class.forName("java.util.Date");
            System.out.println(classzz);
            System.out.println("----------------------");
            //当前三个class 对象 都是描述java.util.Date
            //同一个类加载器中一个类的Class对象只有一个
            System.out.println(aClass == classz);
            System.out.println(classz == classzz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Class dateClass = Date.class;
        try {
            //获得实例化对象
            //通过类的Class对象Class.newInstance创建一个实例化对象，这个类必须具有无参数的构造方法
            Object object = dateClass.newInstance();
            Date date = (Date)object;
            System.out.println(object);
            System.out.println(object instanceof Date);
            System.out.println(object.getClass());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
