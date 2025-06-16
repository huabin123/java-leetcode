package com.huabin.common.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author huabin
 * @DateTime 2025-02-28 15:00
 * @Desc 桶排序
 */
public class BucketSort {
    public static void bucketSort(int[] arr) {
        if (arr.length == 0) return;

        // 1. 确定数据范围
        int max = arr[0], min = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int range = max - min + 1;

        // 2. 创建桶（示例设5个桶，可按数据特性调整）
        int bucketCount = 5;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++)
            buckets.add(new ArrayList<>());

        // 3. 分配元素到桶
        for (int num : arr) {
            int bucketIdx = (num - min) * bucketCount / range;
            buckets.get(bucketIdx).add(num);
        }

        // 4. 对每个桶排序并合并
        int idx = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket)
                arr[idx++] = num;
        }
    }

    public static void main(String[] args) {
        int[] arr = {29, 25, 3, 49, 9, 37, 21, 43};
        bucketSort(arr);
        System.out.println(java.util.Arrays.toString(arr));
        // 输出: [3, 9, 21, 25, 29, 37, 43, 49]
    }
}

