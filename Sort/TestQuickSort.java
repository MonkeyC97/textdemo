package git.com.Sort;

import java.util.Arrays;

import static git.com.Sort.TestMySort.quickSort;

public class TestQuickSort {



    public static int partition(int[] arr, int low, int high) {
        //指定左指针i和右指针j
        int i = low;
        int j = high;
        //将第一个数作为基准值(挖坑)
        int x = arr[i];
        //使用循环实现分区操作
        while(i < j){
            while(i < j && arr[j] > x){
                j--;
            }
            if(i >= j){
                break;
            }else{
                arr[i] = arr[j];
                i++;
            }
            while(i < j && arr[i] < x){
                i++;
            }
            if(i >= j){
                break;
            }else{
                arr[j] = arr[i];
                j--;
            }
        }
        //使用基准值填坑
        arr[i] = x;
        return i;
    }

    private static void quickSort(int[] arr,int low,int high){
        if( low < high){
            //分区操作，把一个数组分成两个分区，返回分区界限的索引
            int index = partition(arr,low,high);
            //对左分区进行快排
            quickSort(arr,low,index - 1);
            //对右分区进行快排
            quickSort(arr,index + 1,high);
        }

    }


    public static void quickSort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr,low,high);
    }


    public static void main(String[] args) {
        //给出无序数组
        int[] arr = {72,6,57,88,60,42,83,99,78,74};
        //输出无序数组
        System.out.println(Arrays.toString(arr));
        //快速排序
        quickSort(arr);
        //输出有序数组
        System.out.println(Arrays.toString(arr));
    }


}
