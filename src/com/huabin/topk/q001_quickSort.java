package com.huabin.topk;

import java.util.Stack;

/**
 * 使用递归及非递归两种方式实现快速排序
 */
public class q001_quickSort {

    public static void quicksortRecursive(int[] arr) {
        quicksortRecursive(arr, 0, arr.length - 1);
    }

    private static void quicksortRecursive(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quicksortRecursive(arr, low, pivotIndex - 1);
            quicksortRecursive(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // 选取最右边的作为基准点
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quicksortIterative(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length - 1);

        while (!stack.isEmpty()) {
            int high = stack.pop();
            int low = stack.pop();

            if (low < high) {
                int pivotIndex = partition(arr, low, high);

                stack.push(low);
                stack.push(pivotIndex - 1);

                stack.push(pivotIndex + 1);
                stack.push(high);
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {9, 4, 7, 2, 1, 5, 8, 3, 6, 0};

        System.out.println("Original array: ");
        printArray(arr);

        // Test recursive quicksort
        quicksortRecursive(arr);
        System.out.println("Array after recursive quicksort: ");
        printArray(arr);

        // Reset the array
        arr = new int[]{9, 4, 7, 2, 1, 5, 8, 3, 6};

        // Test iterative quicksort
        quicksortIterative(arr);
        System.out.println("Array after iterative quicksort: ");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
