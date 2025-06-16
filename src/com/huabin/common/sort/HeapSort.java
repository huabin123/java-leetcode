package com.huabin.common.sort;

/**
 * @Author huabin
 * @DateTime 2025-02-28 14:56
 * @Desc 堆排序
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // 建堆：从最后一个非叶子节点开始调整
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // 排序：逐个提取最大值到末尾
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);    // 把堆顶最大值换到末尾
            heapify(arr, i, 0); // 调整剩余元素为堆
        }
    }

    // 调整以i为根的子树为大顶堆
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;        // 初始化最大值为根
        int left = 2 * i + 1;     // 左子节点索引
        int right = 2 * i + 2;    // 右子节点索引

        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {     // 若最大值不在根节点
            swap(arr, i, largest);
            heapify(arr, n, largest); // 递归调整被影响的子树
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort(arr);
        System.out.println(java.util.Arrays.toString(arr));
        // 输出: [5, 6, 7, 11, 12, 13]
    }
}

