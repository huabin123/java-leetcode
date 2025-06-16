package com.huabin.common.sort;

/**
 * @Author huabin
 * @DateTime 2023-08-17 09:10
 * @Desc
 */
public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    // {10, 7, 5, 8, 3, 11, 1, 6} i = 0
    // [5, 7, 10, 8, 3, 11, 1, 6] i = 1
    // [5, 3, 10, 8, 7, 11, 1, 6] i = 2
    // [5, 3, 1, 8, 7, 11, 10, 6] i = 3 这个3就是pivot的index
    // [5, 3, 1, 6, 7, 11, 10, 8] swap(3, 7)
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pivotIndex = low;

        for (int j = low; j < high; j++) {  // 注意这里j要等于l而不能等于0或者是i,因为是要确定low到high之间的pivot下标
            if (arr[j] < pivot) {  // 其实要找的数不是比pivot大的数，而是比pivot小的数，i是递增的，这就让从low到i-1的位置都比pivot小了，因为是排完之后i++,所以最后的i肯定是大于等于pivot的，所以跳出循环后，交换i,和high的位置，并且返回i即可
                swap(arr, pivotIndex, j);
                pivotIndex++;
            }
        }

        swap(arr, pivotIndex, high);
        return pivotIndex;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 5, 8, 3, 11, 1, 6};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

