package Review.Test.Generic;

class MyClass1<T>{
    public void testMethod1(T t){
        System.out.println(t);
    }
    public <T> T testMethod2(T t){
        return t;
    }

    public <T> void testMethod3(T t){
        System.out.println(t);
    }
}

public class Test3 {
    public static void main(String[] args) {
        MyClass1<String> myClass1 = new MyClass1<String>();
        myClass1.testMethod1("emmm");
        Integer i = myClass1.testMethod2(100);
        myClass1.testMethod3(200);
    }
}
