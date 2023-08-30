package com.huabin.common.sort;

/**
 * @Author huabin
 * @DateTime 2023-08-17 10:20
 * @Desc
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        mergeSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) { // 必须要有递归终止条件
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);  // 注意这里只能是mid，因为如果l=0,r=1,mid就=0，如果是其他值就走不到终止条件
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= m){
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];  // 这里是l+i,不能是l++
        }
    }
}

