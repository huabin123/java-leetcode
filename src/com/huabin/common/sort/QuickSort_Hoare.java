package com.huabin.common.sort;

/**
 * @Author huabin
 * @DateTime 2025-02-28 13:53
 * @Desc 快速排序之Hoare分区方案
 */
public class QuickSort_Hoare {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 分区并获取基准索引
            int pivotIndex = partition(arr, low, high);
            // 递归排序左右子数组（不包含基准）
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Hoare 分区方案（效率较高）
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low + (high - low) / 2]; // 选择中间元素为基准（避免最坏情况）
        int i = low - 1, j = high + 1;

        while (true) {
            // 找到左侧首个大于等于基准的元素
            do {
                i++;
            } while (arr[i] < pivot);
            // 找到右侧首个小于等于基准的元素
            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) return j; // 终止条件

            swap(arr, i, j); // 交换不符合条件的元素
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10};
        quickSort(arr);
        System.out.println(java.util.Arrays.toString(arr));
        // 输出: [1, 2, 3, 4, 5, 7, 8, 10]
    }
}

