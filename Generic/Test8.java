package Review.Test.Generic;

/**
 * 泛型接口的定义与使用
 */
interface IMessage<T>{
    public void print(T t);
}
class Gclass<T> implements IMessage<String>{


    @Override
    public void print(String s) {
        System.out.println(s);
    }
}

public class Test8 {
    public static void main(String[] args) {
        IMessage<String> message = new Gclass<>();
        message.print("hello world");
    }
}
