package com.huabin.algorithm.primary;

/**
 * @Author huabin
 * @DateTime 2022-06-16 13:16
 * @Desc 插入排序
 */
public class Code03_InsertSort {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    public static int[] sort(int[] array){
//        // 处理边界条件
//        if (array.length == 0 || array.length == 1) {
//            return array;
//        }
//        // 保证0-1，0-2，0-3。。。0-n位置有序
//        for (int end = 1;  end < array.length; end++) {
//            int newNumIndex = end;
//            while (newNumIndex-1>=0 && array[newNumIndex-1]>array[newNumIndex]){
//                swap(array,newNumIndex-1,newNumIndex);
//                newNumIndex--;
//            }
//        }
//        return array;
//    }

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 10, 6, 3, 1, 8, 9, 5, 3, 0};
        for (int j : sort(array)) {
            System.out.print(j + " ");
        }
    }

    public static int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            int newNumIndex = i;
            while (newNumIndex - 1 >= 0 && array[newNumIndex - 1] > array[newNumIndex]){
                swap(array, newNumIndex - 1, newNumIndex);
                newNumIndex--;
            }
        }
        return array;
    }
}
