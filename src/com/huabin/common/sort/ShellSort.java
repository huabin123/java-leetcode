package com.huabin.common.sort;

/**
 * @Author huabin
 * @DateTime 2025-02-28 08:40
 * @Desc 希尔排序
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        int n = arr.length;

        // 初始增量设为数组长度的一半，逐步缩小增量
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // 对每个子序列进行插入排序
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;

                // 插入操作：将 arr[i] 插入到所在子序列的正确位置
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 3, 1, 8, 6, 4, 2};
        System.out.println("原数组: " + arrayToString(arr));

        shellSort(arr);
        System.out.println("排序后: " + arrayToString(arr));
    }

    // 辅助方法：将数组转为字符串便于输出
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

