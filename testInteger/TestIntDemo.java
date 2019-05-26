package com.monkeyc.testInteger;

class IntDemo{
    private int num;
    public IntDemo(int num){
        this.num = num;
    }
    public int intValue(){
        return this.num;
    }
}
public class TestIntDemo {
    public static void main(String[] args) {
     Object obj = new IntDemo(22);//向上转型
     IntDemo intDemo = (IntDemo)obj;//强制转型
        System.out.println(((IntDemo) obj).intValue());
    }
}
