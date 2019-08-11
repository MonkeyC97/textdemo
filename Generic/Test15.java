package Review.Test.Generic;

interface IMessage2{
    void print();
}

public class Test15 {
    public static void main(String[] args) {
        IMessage2 message2 = new IMessage2() {//匿名内部类
            @Override
            public void print() {
                System.out.println("MyMessage");
            }
        };
        message2.print();
    }
}
