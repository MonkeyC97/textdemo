package git.com.Sort;

import java.util.Arrays;
import java.util.Random;

//直接插入排序越有序越快
public class TestMySort {
    public static int[] insertSort(int[] array){
      int tmp = 0;
      for(int i = 1; i < array.length;i++){
          tmp = array[i];
          int j = 0;
          for(j = i - 1; j >= 0;j--){
              if(array[j] > tmp){
                  array[j + 1] = array[j];
              }else{
                  array[j + 1] = tmp;
              }
          }
          array[j + 1] = tmp;
      }
      return array;
    }
    //希尔排序
    public static int[] shell(int[] array,int gap){
        int i = gap;
        int tmp;
        for(;i < array.length;i++){
            tmp = array[gap];
            int j = 0;
            for(j = gap - 1; j >= 0;j++){
                if(array[gap] > tmp){
                    array[gap + 1] = array[gap];
                }else{
                    array[i] = tmp;
                }
            }
            array[j+gap] = tmp;
        }
        return array;
    }
    public static void shellSort(int[] array){
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }
    public static void selectSort(int[] array){
        int i = 0;
        int j = i+1;
        for(; i < array.length;i++){
            for(; j < array.length;j++){
                if(array[j] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    //把这颗树调整为大根堆
    public static void adjust(int[] array, int start,int end){
        int tmp = array[start];
        for(int i = 2*start+1; i <= end; i = i * 2 + 1){
            if((i<end) && array[i] < array[i+1]){
                i++;//左右孩子里面的最大值下标
            }
            if(array[i] > tmp){
                array[start] = array[i];
                start = i;
            }

            if(array[i] < tmp){
//                array[start] = tmp;
                break;
            }
        }
        array[start] = tmp;
    }
    public static void heapSort(int[] array){
        long start = System.currentTimeMillis();

        for (int i = (array.length-1-1)/2; i>=0; i--) {//n/2
            adjust(array,i,array.length-1);//log2n
        }
        //整棵树调整为大根堆的时间复杂度？nlog2n
        //交换
        for(int j = 0;j < array.length-1;j++){
            int tmp = array[array.length-1-j];
            array[array.length-1-j] = array[0];
            array[0] = tmp;
            //array.length-1-j  -1:上面已经交换说明有序了
            //调整的时候，不需要调整有序的数据。
            adjust(array,0,array.length-1-j-1);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    public static int partion(int[] array,int low,int high){
        int tmp = array[low];
        low = 0;
        high = array.length-1;

        while(low < high){
            while(low < high && array[high] > tmp){
                high--;
            }
            if(low >= high){
                break;
            }else{
                array[low] = array[high];
            }
            while(low < high && array[low] < tmp){
                low++;
            }
            if(low >= high){
                break;
            }else{
                array[high] = array[low];
            }
        }
        array[low] = tmp;
        return low;
    }
    public static void insertSort1(int[] array ,int start,int end){
        int i = start+1;
        int tmp;
        int j = 0;
        for(j = i -1;i <= end;i++){
            tmp = array[i];
            for(;j >= start;j++){
                if(array[j] >tmp){
                   array[j+1] = array[i];
                }else{
                    array[i] = tmp;
                }
            }
        }
    }

    public static void swap(int[] array,int start,int end){
        int tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;
    }


    public static void medianOfThree(int[] array,int low,int high){
        int mid = (low + high) >>>1;
        int tmp = array[mid];
        if(array[mid] > array[low]){
            swap(array,mid,low);
        }
        if(array[high] < array[high]){
            swap(array,mid,high);
        }
        if(array[low] > array[high]){
            swap(array,low,high);
        }
    }


    public static void quick(int[] array,int start,int end){
        //1 2 3 4 5
        if(end-start+1 <= 16){
            insertSort1(array,start,end);
            return;
        }

        int par = partion(array,start,end);
        //找左边是否有两个数据以上
        if(par > start+1){
            quick(array,start,par-1);
        }
        //右边是否有两个数据以上
        if(par < end-1){
            quick(array,par+1,end);
        }
    }


    public static void quickSort1(int[] array){
        long start = System.currentTimeMillis();
        quick(array,0,array.length-1);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }


    //非递归实现快速排序
    public static void quickSort(int[] array){
        int[] stack = new int[array.length * 2];
        int top = 0;
        int low = 0;
        int high = array.length - 1;
        //先进行一趟快速排序
        int par = partion(array,low,high);
        //1  判断当前par的左右两边是否有两个数据以上
        if(par > low + 1){
            stack[top++] = low;
            stack[top++] = par - 1;
        }
        if(par < high - 1){
            stack[top++] = high;
            stack[top++] = par + 1;
        }
        //以上代码执行完毕，两边的数对已经全部入栈
        //需要做的工作就是判断栈是否为空，不为空，取出两个数对进行partition
        while(low < high){
            while(top > 0){
                high = stack[--top];
                low = stack[--top];
                partion(array,low,high);
                if(par > low + 1){
                    stack[top++] = low;
                    stack[top++] = par - 1;
                }
                if(par < high - 1){
                    stack[top++] = high;
                    stack[top++] = par + 1;
                }
            }
        }
    }

    public static void merge(int[] array,int start,int mid,int end){
        int[] tmp = new int[array.length];
        int tmpIndex = start;

        int start2 = mid + 1;
        int i = start;
        while(start <= mid && start2 <= end){
            if(array[start] <= array[start2]){
                tmp[start] = array[start];
                start++;
            }else{
                tmp[start] = array[start2];
                start2++;
            }
        }
        while(start <= mid){
            tmp[start] = array[start];
            start++;
        }
        while(start2 <= end){
            tmp[start] = array[start2];
            start2++;
        }
        while(i <= end){
            array[i] = tmp[i];
            i++;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array,int start,int end){
        if(start >= end){
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array,mid + 1,end);
        //肯定是一个一个的有序的序列

        merge(array,start,mid,end);

    }

    public static void main(String[] args) {
        int[] array = {12,5,2,4,9,78,43,21};
//        Random random = new Random();
//        int[] array = new int[100000];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt(10000)+1;
//        }
//        quickSort(array);
//        System.out.println(Arrays.toString(array));
        mergeSort(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
