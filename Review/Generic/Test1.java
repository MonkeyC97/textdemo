package Review.Test.Generic;

/**
 * 现在假设说有这样的要求:
 * 要求设计⼀一个⽅方法，
 * ⽤用于计算任意参数的整数的相加结果。
 * 早期思想，使用数组
 */

public class Test1 {
    public static void main1(String[] args) {
        System.out.println(add1(new int[]{1,2,3}));
        System.out.println(add1(new int[]{1,2,3,4,5,6,7}));
        System.out.println(add1(new int[]{1,2,3,4,5,6,7,8,9}));

    }
    public static int add1(int[] a){
        int sum = 0;
        for(int i = 0; i < a.length;i++){
            sum+=a[i];
        }
        return sum;
    }

    public static void main2(String[] args) {
        System.out.println(add2("hehe",new int[]{1,2,3,4}));
        System.out.println(add2("haha",1,2,3,4));
        System.out.println(new int[]{1,2,3,4,5,6,7,8,9});
    }
    public static int add2(String msg,int ... a){
        int sum = 0;
        for(int i = 0; i <= a.length;i++){
            sum+=a[i];
        }
        return sum;
    }

    static int[] a = new int[]{1,2,3,4,5,6};

    public static void main(String[] args) {
        int sum = 0;
        for(int x : a){
            System.out.println(x);
        }
    }
}
