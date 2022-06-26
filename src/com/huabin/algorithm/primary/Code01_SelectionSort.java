package com.huabin.algorithm.primary;

import java.util.Arrays;

public class Code01_SelectionSort {

    public static int[] sort(int[] array){
        // 处理边界条件
        if (array.length == 0 || array.length == 1) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minNum = array[i];
            for(int j=i+1; j< array.length; j++){
                if (array[j]<minNum){
                    minNum = array[j];
                    swap(array, i, j);
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
        int[] array = {3, 1, 4, 6, 3, 1, 8, 9, 5, 3};
        for (int j : sort(array)) {
            System.out.print(j + " ");
        }
    }

}
