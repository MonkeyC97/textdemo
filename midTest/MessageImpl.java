package com.monkeyc.midTest;

public class MessageImpl implements IMessage,INews{
    @Override
    public void print() {
        System.out.println(IMessage.msg);
    }

    @Override
    public String getNews() {
        return IMessage.msg;
    }

    public static void main(String[] args) {
        IMessage iMessage = new MessageImpl();//发生了向上转型
        iMessage.print();
        INews inews = (INews) iMessage;
        System.out.println(inews.getNews());
    }
}
