package Review.Test.Generic;

/**
 * 多个类型参数的泛型类的定义
 *
 */

class MyClass<T,V>{
    private T value1;
    private V value2;
}
public class Test {
    public static void main(String[] args) {
        MyClass<String,Integer> myClass = new MyClass<String,Integer>();
    }
}
