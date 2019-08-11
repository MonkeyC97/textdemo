package Review.Test.Generic;




interface IMessage1{
    public default void fun(){
        System.out.println("hehe");
    }

    public static IMessage1 message(){
        return new MyMessage1();
    }
    public void print();
}

class MyMessage1 implements IMessage1{

    @Override
    public void print() {
        System.out.println("hello");
    }
}
public class Test14 {
    public static void main(String[] args) {
        IMessage1 message1 = IMessage1.message();
        message1.print();
        message1.fun();
    }
}
