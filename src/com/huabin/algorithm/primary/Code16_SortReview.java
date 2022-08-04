package com.huabin.algorithm.primary;

/**
 * @Author huabin
 * @DateTime 2022-07-31 22:15
 * @Desc 排序算法复习
 */
public class Code16_SortReview {

    // 冒泡
    private static void sortBubble(int[] nums){
        if (nums.length == 1 || nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j]>nums[j+1]){
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    // 选择排序
    private static void sortSelect(int[] nums){
        int min;  // 最小数的下标

        for (int i = 0; i < nums.length; i++) {
            min = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]<nums[min]){
                    min = j;
                }
            }
            if (min!=i){
                swap(nums, i, min);
            }
        }
    }

    // 插入排序
    private static void sortInsert(int[] nums){
        for (int end = 1; end < nums.length; end++) {
            while (end - 1>=0 && nums[end-1]>nums[end]){
                swap(nums, end-1 , end);
                end--;
            }
        }
    }

    // ========== 快速排序start================
    private static void quickSort(int[] nums, int startIndex, int endIndex){
        if (startIndex>=endIndex) {
            return;
        }
        // 得到确认好位置的基准元素下标
        int pivotIndex = partition(nums, startIndex, endIndex);
        quickSort(nums, startIndex, pivotIndex-1);
        quickSort(nums, pivotIndex+1, endIndex);
    }

    // 双指针移动法
    private static int partition(int[] nums, int startIndex, int endIndex) {
        int pivot = nums[startIndex];  // 开始位置的值作为基准值
        int left = startIndex;
        int right = endIndex;
        while (left != right){
            while (left < right && nums[right] > pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot){
                left++;
            }
            if (left<right){
                swap(nums, left ,right);
            }
        }
        // left和right重合
        int p = nums[left];
        nums[startIndex] = p;
        nums[left] = pivot;
        return left;
    }
    // ========== 快速排序end================

    // ==========归并排序start================
    private static void mergeSort(int[] nums, int start, int end){
        if (start<end) {
            // 找到中点
            int mid = start + ((end - start) >> 1);
            mergeSort(nums, start, mid);
            mergeSort(nums, mid+1, end);
            merge(nums, start, mid, end);
        }
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] tmpList = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        int p = 0;
        while (p1<=mid && p2<=end){
            if (nums[p1]<nums[p2]){
                tmpList[p++] = nums[p1++];
            } else {
                tmpList[p++] = nums[p2++];
            }
        }
        // 左边有剩余
        while (p1<=mid){
            tmpList[p++] = nums[p1++];
        }
        // 右边有剩余
        while (p2<=end){
            tmpList[p++] = nums[p2++];
        }
        // 临时数组的值复制回原数组
        for (int i = 0; i < tmpList.length; i++) {
            nums[i+start] = tmpList[i];
        }
    }
    // ==========归并排序end================


    private static void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }

    public static void main(String[] args) {
        int[] origin = {3, 1, 5, 7, 2, 45, 7, 1};
        mergeSort(origin,0, origin.length-1);
        for (int i = 0; i < origin.length; i++) {
            System.out.println(origin[i]);
        }
    }


}
