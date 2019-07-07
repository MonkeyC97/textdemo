package com.leetcode.test;

    public class FoundK{
        public static void main(String[] args) {
            FoundK foundK = new FoundK();
            System.out.println(foundK.find(new int[]{1, 5, 8, 7, 5}, 5, 2));
        }

        public int find(int[] arr, int n, int k) {
            return findK(arr, 0, n - 1, k);
        }

        public int findK(int[] arr, int low, int high, int k) {
            //1.首先根据快速排序的思想进行分组
            int part = partition(arr, low, high);
            //2.分好组后，得到基准值key的位置
            //3.1low是这一组最小的下标，part-low+1就是第k大
            if (k == part - low + 1) {
                return arr[part];
                //3.2如果第k个比基准值key大，则在另一组中
            } else if (k > part - low + 1) {
                return findK(arr, part + 1, k - part + low - 1, k);
            } else {
                //3.3如果第k个比基准值key小，则在左边
                return findK(arr, low, part - 1, k);
            }
        }

        public int partition(int[] arr, int low, int high) {
            int key = arr[low];
            //找一个key当做中间值
            //然后将比它大的放左边，比它小的放右边
            while (low < high) {
                //比它小的位置不变，下标减小
                while (low < high && arr[high] <= key) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] >=key) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = key;
            return low;
        }
    }

