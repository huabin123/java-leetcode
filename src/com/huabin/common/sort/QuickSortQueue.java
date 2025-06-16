package com.huabin.common.sort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author huabin
 * @DateTime 2025-02-28 14:12
 * @Desc 快速排序（队列实现）
 */
public class QuickSortQueue {

    public static void queueQuickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);                     // 左边界入队
        queue.offer(arr.length - 1);        // 右边界入队

        while (!queue.isEmpty()) {
            int low = queue.poll();         // 取出左边界
            int high = queue.poll();        // 取出右边界

            int pivotIndex = partition(arr, low, high);

            // 入队顺序：先左子区间，再右子区间（FIFO分层处理）
            if (low < pivotIndex) {
                queue.offer(low);           // 左区间的左边界
                queue.offer(pivotIndex);    // 左区间的右边界
            }
            if (pivotIndex + 1 < high) {
                queue.offer(pivotIndex + 1);// 右区间的左边界
                queue.offer(high);          // 右区间的右边界
            }
        }
    }

    // 使用与栈版本相同的Hoare分区
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low + (high - low) / 2];
        int i = low - 1, j = high + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) return j;
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10};
        queueQuickSort(arr);
        System.out.println(java.util.Arrays.toString(arr));
        // 输出: [1, 2, 3, 4, 5, 7, 8, 10]
    }
}

