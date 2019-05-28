package com.monkeyc.io;

import java.util.Scanner;

public class TestScanner {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("键盘读取");
//        if(scanner.hasNext()){
//            System.out.println(scanner.next());
//        }
//        if(scanner.hasNextInt()){
//            System.out.println(scanner.nextInt());
//        }else{
//            System.out.println("输入的内容不是整数");
//        }
        //1997-07-30
        //\d表示0-9
        //{4}表示出现的次数（4次）
        if(scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")){
            System.out.println(scanner.next());
        }else{
            System.out.println("生日格式有误");
        }
        scanner.close();
    }

    public static void main(String[] args) {

    }
}
