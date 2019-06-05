package com.monkeyc.testTryCatch;
/**
 使用try catch实现多个异常的捕获
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("数学计算之前");
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        try{
            System.out.println(x/y);
        }catch (ArithmeticException e) {
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException b){
            b.printStackTrace();
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("不论是否发生异常，都会执行finally");
        }
        System.out.println("数学计算之后");
    }
}
