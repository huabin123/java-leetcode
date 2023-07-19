package com.huabin.topk;


/**
 * 使用递归及非递归两种方式实现快速排序
 */
public class Q001_QuickSort {

    // 递归实现
    public static void quicksortRecursive(int[] array){
        quicksortRecursive(array, 0, array.length - 1);
    }

    private static void quicksortRecursive(int[] array, int L, int R){
        if (L < R) {
            int pivotIndex = partition(array, L, R);
            quicksortRecursive(array, L, pivotIndex - 1);
            quicksortRecursive(array, pivotIndex + 1, R);
        }
    }

    private static int partition(int[] array, int L, int R){
        int pivot = array[R];
        int less = L - 1;
        int index = L;
        while (index < R) {
            if (array[index] < pivot) {
                less++;
                swap(array, index, less);
            }
            index++;
        }
        swap(array, less+1, R);
        return less+1;
    }


    public static void swap(int[] array, int L, int R){
        int temp = array[L];
        array[L] = array[R];
        array[R] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 4, 7, 3, 2, 1, 5, 8, 3, 6};
        quicksortRecursive(arr);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
