package com.leetcode.test;

/**
 *  编程题2：有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 *  给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 */

public class TestDay01_3 {

    public class Finder {

        public int findKth(int[] a, int n, int K) {
            return findKth(a, 0, n-1, K);
        }

        public int findKth(int[] a, int low, int high, int k) {
            int part = partation(a, low, high);
            if(k == part - low + 1) return a[part];//如果是第一大
            else if(k > part - low + 1) return findKth(a, part + 1, high, k - part + low -1);
            else return findKth(a, low, part -1, k);
        }

        public int partation(int[] a, int low, int high) {
            int key = a[low];
            while(low < high) {
                while(low < high && a[high] <= key) high--;
                a[low] = a[high];
                while(low < high && a[low] >= key) low++;
                a[high] = a[low];
            }
            a[low] = key;
            return low;
        }
    }
}
