package com.huabin.common.sort;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author huabin
 * @DateTime 2025-02-28 14:05
 * @Desc 快速排序（栈实现）
 */
public class QuickSortIterative {

    public static void iterativeQuickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);                  // 先压左边界
        stack.push(arr.length - 1);     // 后压右边界

        while (!stack.isEmpty()) {
            int high = stack.pop();     // 弹出时先取右边界
            int low = stack.pop();      // 再取左边界

            int pivotIndex = partition(arr, low, high);

            // 先压右子区间，再压左子区间（利用栈的LIFO特性）
            if (pivotIndex + 1 < high) {
                stack.push(pivotIndex + 1); // 右区间的左边界
                stack.push(high);           // 右区间的右边界
            }
            if (low < pivotIndex) {
                stack.push(low);            // 左区间的左边界
                stack.push(pivotIndex);     // 左区间的右边界
            }
        }
    }

    // Hoare分区方案（完整版）
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low + (high - low) / 2]; // 中间基准
        int i = low - 1, j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) return j; // 返回分割点

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
        iterativeQuickSort(arr);
        System.out.println(java.util.Arrays.toString(arr));
        // 输出: [1, 2, 3, 4, 5, 7, 8, 10]
    }
}

