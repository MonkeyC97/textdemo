package Review.Test.Generic;

interface IMyMessage{
    public default void fun(){//接口中定义了普通方法，有方法体
        System.out.println("hehe");
    }
    public void print();

}
class MessageImpl implements IMyMessage{

    @Override
    public void print() {
        System.out.println("haha");
    }
}

public class Test13 {
    public static void main(String[] args) {
        IMyMessage myMessage = new MessageImpl();
        myMessage.print();
        myMessage.fun();
    }
}
