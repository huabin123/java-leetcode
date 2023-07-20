package com.huabin.topk;


/**
 * 使用递归及非递归两种方式实现快速排序
 */
public class Q001_QuickSort {

    // 递归实现
    public static void quicksortRecursive(int[] array){
        quicksortRecursive(array, 0, array.length - 1);
    }

    private static void quicksortRecursive(int[] array, int L, int R){
        if (L < R) {
            int pivotIndex = partition(array, L, R);
            quicksortRecursive(array, L, pivotIndex - 1);
            quicksortRecursive(array, pivotIndex + 1, R);
        }
    }

    private static int partition(int[] array, int L, int R){
        int pivot = array[R];
        int less = L - 1;
        int index = L;
        while (index < R) {
            if (array[index] < pivot) {
                less++;
                swap(array, index, less);
            }
            index++;
        }
        swap(array, less+1, R);
        return less+1;
    }

    // --------- 递归实现2.0 三轴排序，分区函数返回等于基准值的数组 -----------
    public static void quicksortRecursive2(int[] array){
        quicksortRecursive2(array, 0, array.length - 1);
    }

    public static void quicksortRecursive2(int[] array, int L, int R){
        if (L < R) {
            int[] equalArea = partition2(array, L, R);
            quicksortRecursive2(array, L, equalArea[0] - 1);
            quicksortRecursive2(array, equalArea[1] + 1, R);
        }
    }

    public static int[] partition2(int[] array, int L, int R){
        int less = L - 1;
        int more = R;
        int index = L;
        int RV = array[R];
        while (index < more) {
            int indexV = array[index];
            if (indexV == RV) {
                index++;
            } else if (indexV > RV) {
                more--;
                swap(array, index, more);
            } else {
                less++;
                swap(array, index, less);
                index++;
            }
        }
        swap(array,more,R);
        return new int[]{less+1, more};
    }

    // --------- 递归实现3.0 把arr[R]作为基准点改为选择L,R内随机一个作为基准点，这样时间复杂度就是nlogn -----------
    public static void quicksortRecursive3(int[] array) {
        quicksortRecursive2(array, 0, array.length - 1);
    }

    public static void quicksortRecursive3(int[] array, int L, int R) {
        if (L < R) {
            swap(array, L + (int) (Math.random() * (R - L + 1)), R);
            int[] equalArea = partition3(array, L, R);
            quicksortRecursive3(array, L, equalArea[0] - 1);
            quicksortRecursive3(array, equalArea[1] + 1, R);
        }
    }

    public static int[] partition3(int[] array, int L, int R) {
        int less = L - 1;
        int more = R;
        int index = L;
        int RV = array[R];
        while (index < more) {
            int indexV = array[index];
            if (indexV == RV) {
                index++;
            } else if (indexV > RV) {
                more--;
                swap(array, index, more);
            } else {
                less++;
                swap(array, index, less);
                index++;
            }
        }
        swap(array, more, R);
        return new int[]{less + 1, more};
    }


    public static void swap(int[] array, int L, int R){
        int temp = array[L];
        array[L] = array[R];
        array[R] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 4, 7, 3, 2, 1, 5, 8, 3, 6};
        quicksortRecursive(arr);
        printArray(arr);

        // Test quicksortRecursive2
        arr = new int[]{9, 4, 7, 3, 2, 1, 5, 8, 3, 6};
        quicksortRecursive2(arr);
        printArray(arr);

        // Test quicksortRecursive3
        arr = new int[]{9, 4, 7, 3, 2, 1, 5, 8, 3, 6};
        quicksortRecursive3(arr);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
