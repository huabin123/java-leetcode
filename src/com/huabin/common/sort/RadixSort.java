package com.huabin.common.sort;

import java.util.Arrays;

/**
 * @Author huabin
 * @DateTime 2025-02-28 15:04
 * @Desc 基数排序
 */
public class RadixSort {
    public static void radixSort(int[] arr) {
        if (arr.length == 0) return;

        int max = Arrays.stream(arr).max().getAsInt();
        int exp = 1; // 从个位开始

        while (max / exp > 0) {
            int[] output = new int[arr.length];
            int[] count = new int[10]; // 0-9数字频率统计

            // 统计当前位数字出现次数
            for (int num : arr)
                count[(num / exp) % 10]++;

            // 计算前缀和确定位置
            for (int i = 1; i < 10; i++)
                count[i] += count[i - 1];

            // 反向填充保证稳定性
            for (int i = arr.length - 1; i >= 0; i--) {
                int digit = (arr[i] / exp) % 10;
                output[count[digit] - 1] = arr[i];
                count[digit]--;
            }

            System.arraycopy(output, 0, arr, 0, arr.length);
            exp *= 10; // 处理更高位
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
        // 输出: [2, 24, 45, 66, 75, 90, 170, 802]
    }
}

