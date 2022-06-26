package com.huabin.algorithm.primary;

/**
 * @Author huabin
 * @DateTime 2022-06-15 12:55
 * @Desc 冒泡排序
 */
public class Code02_BubbleSort {

    public static int[] sort(int[] array){
        // 处理边界条件
        if (array.length == 0 || array.length == 1) {
            return array;
        }
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length-j-1; i++) {
                if (array[i]>array[i+1]) {
                    swap(array, i, i+1);
                }
            }
        }
        return array;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 10, 6, 3, 1, 8, 9, 5, 3};
        for (int j : sort(array)) {
            System.out.print(j + " ");
        }
    }
}
