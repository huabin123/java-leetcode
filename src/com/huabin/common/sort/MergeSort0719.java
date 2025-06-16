package com.huabin.common.sort;

/**
 * @Author huabin
 * @DateTime 2023-08-17 10:20
 * @Desc
 */
public class MergeSort0719 {

    public static void main(String[] args) {
        int[] arr = {10, 7, 5, 8, 3, 11, 1, 6};
        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] arr, int l, int r){
        if (l >= r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);  // 这时候mid左边和右边的都已经组内有序了，需要合并了
    }

    public static void merge(int[] arr, int l, int mid, int r){
        int[] help = new int[r - l + 1];
        int i = 0;  // help数组里的辅助索引
        int p1 = l;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
    }


}

