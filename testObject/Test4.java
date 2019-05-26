package com.monkeyc.testObject;

/*
使用Object接收接口对象
 */
interface IMessage {
    void getMessage();
}

class MessageImpl implements IMessage {
    @Override
    public void getMessage() {
        System.out.println("hello world");
    }

    public String toString(){
        return "hehe world";
    }
}

public class Test4 {
    public static void main(String[] args) {
        Object obj = new MessageImpl();
        System.out.println(obj);
        IMessage temp = (IMessage)obj;
        temp.getMessage();
    }
}
