package com.leetcode.test;
/**
 * 打印结果 12  -11
 */

public class TestDay01_1 {
    public static void main(String[] args) {
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));
        /**
         * 解析如下:
         * java.lang.Math.round函数的作用是返回参数中最接近的值，其中参数四舍五入为正无穷大，所以-11.5四舍五入为-11
         */
        System.out.println(Math.ceil(11.4));
        System.out.println(Math.ceil(-11.2));
        System.out.println(Math.ceil(11.5));
        System.out.println(Math.ceil(-11.5));
        /**
         * Math.ceil为向下取整，返回值类型为double
         * 打印结果为12.0  -11.0 12.0 -11.0
         * 也就是说若参数为正数则把小数"入"（不考虑四舍五入直接入），若参数为负数则把小数去掉
         */

        System.out.println(Math.floor(11.9));
        System.out.println(Math.floor(-11.2));
        /**
         * Math.floor方法的功能是向下取整，ceil意思为天花板，floor意思为地板
         * 返回值同样为double
         * 与ceil(天花板)方法相反
         */
    }
}
