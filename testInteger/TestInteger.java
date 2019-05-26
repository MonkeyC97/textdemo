package com.monkeyc.testInteger;

public class TestInteger {
    public static void main1(String[] args) {
        Integer num = new Integer(5);
        System.out.println(++num* 8);
        System.out.println(num);
    }

    public static void main2(String[] args) {
        Integer num = 5;//自动装箱
        System.out.println(num*8);
    }

    public static void main3(String[] args) {
        Integer num1 = new Integer(10);
        Integer num2 = new Integer(10);
        System.out.println(num1 == num2);
        System.out.println(num1.equals(num2));
        System.out.println(num1 == new Integer(10));
        System.out.println(num1.equals(new Integer(10)));
    }
        //将字符串转换成int类型
    public static void main4(String[] args) {
        String str = "123456789";//字符串只能为数字
        int num = Integer.parseInt(str);
        System.out.println(num);
    }
        //将字符串转换成double类型
    public static void main5(String[] args){
        String str = "123.0";
        double num = Double.parseDouble(str);
        System.out.println(num);
    }

    public static void main(String[] args) {
        String str = String.valueOf(100);
        double num = Double.parseDouble(str);
        System.out.println(num);
    }

}
