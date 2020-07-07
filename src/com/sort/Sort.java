package com.sort;


import java.util.Arrays;

public class Sort {
    public static void main(String[] args){
        int[] num = {12,34,56,89,11,67,46,97,23};
        //System.out.println(Arrays.toString(BubbleSort(num)));
        //System.out.println(Arrays.toString(SelectionSort(num)));
        //System.out.println(Arrays.toString(InsertSort(num)));
        //System.out.println(Arrays.toString(QuickSort(num,0,num.length-1)));
        System.out.println(BinarySearch(BubbleSort(num),12));
    }

    /**
     * 冒泡排序
     * @param num
     * @return
     */
    public static int[] BubbleSort(int[] num){
        for(int i = 0;i<num.length-1;i++){
            for(int j = 0;j<num.length-i-1;j++){
                if(num[j]>num[j+1]){
                    int tmp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = tmp;
                }
            }
        }
        return num;
    }

    /**
     * 选择排序
     * @param num
     * @return
     */
    public static int[] SelectionSort(int[] num){
        for(int i = 0;i<num.length-1;i++){
            int min = i;
            for(int j = i+1;j<num.length;j++){
                if(num[i]>num[j]){
                    min = j;
                }
            }
            int temp = num[i];
            num[i] = num[min];
            num[min] = temp;
        }
        return num;
    }

    /**
     * 插入排序
     * @param num
     * @return
     */
    public static int[] InsertSort(int[] num){
        for(int i=1;i<num.length;i++){
            int key = num[i];
            int j = i-1;
            while (j>=0&&num[j]>key){
                num[j+1] = num[j];
                j--;
            }
            num[j+1] = key;
        }
        return num;
    }

    /**
     * 快速排序
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int[] QuickSort(int arr[], int low, int high) {
        int l = low;
        int h = high;
        int k = arr[low];
        while (l < h) {
            // 从后往前比较
            while (l < h && arr[h] >= k) { // 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                h--;// h=6
            }
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                //进行过一次替换后，没必要将替换后的两值再次比较，所以i++直接下一位与k对比
                l++;
            }
            // 从前往后比较
            while (l < h && arr[l] <= k) { // 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                l++;
            }
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
            // 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用

            System.out.print("l=" + (l + 1) + "；h=" + (h + 1) + "；k=" + k + "\n");
            // 递归
            if (l > low)//先判断l>low再次经行左边排序
                QuickSort(arr, low, l - 1);// 左边序列。第一个索引位置到关键值索引-1
            if (h < high)//左边依次排序执行完递归后，弹栈进行右边排序
                QuickSort(arr, l + 1, high);// 右边序列。从关键值索引+1到最后一个
        }
        return arr;
    }

    /**
     * 二分查找
     */
    public static String BinarySearch(int[] num,int a){
        int l = 0;
        int h = num.length-1;
        while(l<h){
            int mid = (l+h)/2;
            if(a<num[mid]){
                h = mid;
            }else if (a>num[mid]){
                l = mid;
            }else{
                return "success："+num[mid]+"数组下标："+mid;
            }
        }
        return "fail";
    }
}