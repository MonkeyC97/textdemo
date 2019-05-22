package com.monkeyc.testString;

import java.util.Scanner;
public class CheckPailndrome {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if(isPailndrome(s)){
            System.out.println(s+"是回文");
        }else{
            System.out.println(s+"不是回文");
        }
    }

    public  static boolean isPailndrome(String s){

        int low = 0;
        int high = s.length() - 1;
        while (low < high){
            if(s.charAt(low) == s.charAt(high)){

                return true;
            }else{
                low++;
                high--;
            }
        }
        return false;
    }
}
