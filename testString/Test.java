package com.monkeyc.testString;

public class Test {

    public static void main1(String[] args) {
        char[] a = new char[]{'c','a','b','u','r'};
        String s = new String(a,2,3);
        System.out.println(s);
    }

    public static void main2(String[] args) {
        String s = new String("hello");
        System.out.println(s);
    }

    public static void main3(String[] args) {
        char[] a = new char[]{'a','c','b','r'};
        System.out.println(a);
    }

    public static void main4(String[] args) {
        byte[] a = new byte[]{97,98,99,100,101,102};
        String s = new String(a,1,3);
        System.out.println(s);
    }

    public static void main5(String[] args) {
        String s = "monkeyc97 need to study harder and harder";
        String s1 = "1997-06-26";
        int n1 = s.length();
        int n2 = s1.length();
        System.out.println(n1);
        System.out.println(n2);
    }

    public static void main6(String[] args) {
        String s1 = new String("hehe");
        String s2 = new String("hehe");
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);
    }


    public static void main7(String[] args) {
        String s = new String("hehe");
        String s1 = new String("HEHE");
        System.out.println(s.equalsIgnoreCase(s1));
    }

    public static void main8(String[] args) {
        String s = ("649152");
        String s1 = ("3718");
        System.out.println(s.startsWith("649"));
        System.out.println(s1.startsWith("083"));
    }

    public static void main9(String[] args) {
        String s1 = "abc";
        String s2 = "abf";
        System.out.println(s1.compareTo(s2));
    }

    public static void main10(String[] args) {
        String s1 = "helloworld";
        System.out.println(s1.indexOf("or",5));
    }

    public static void main11(String[] args) {
        String s1 = "heheworld";
        System.out.println(s1.substring(20));
    }

    public static void main12(String[] args) {
        String s1 = "hello world";
        String s2 = s1.replaceAll("l","2");
        System.out.println(s2);
    }

    public static void main13(String[] args) {
        String s1 = "   I love you";
        System.out.println(s1.trim());
    }

    public static void main14(String[] args) {
        String s1 = "I love you";
        String s2 = " three thousands times";
        System.out.println(s1.concat(s2));
    }

    public static void main15(String[] args) {
        String s1 = "I am so sorry";
        char[] a = new char[]{};
        s1.getChars(1,2,a,1);
    }

    public static void main(String[] args) {
        String s1 = "four years no calls";
        char[] s = new char[20];
        s = s1.toCharArray();
        System.out.println(s[1]);
    }

}
