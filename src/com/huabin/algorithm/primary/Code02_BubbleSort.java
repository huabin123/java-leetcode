package com.huabin.algorithm.primary;

/**
 * @Author huabin
 * @DateTime 2022-06-15 12:55
 * @Desc 冒泡排序
 */
//public class Code02_BubbleSort {
//
//    public static int[] sort(int[] array){
//        // 处理边界条件
//        if (array.length == 0 || array.length == 1) {
//            return array;
//        }
//        for (int j = 0; j < array.length; j++) {  // 第一层循环每循环一次就能确定一个最大的数
//            for (int i = 0; i < array.length-j-1; i++) {  // 除去已经排完序的数字就是第二层循环的范围
//                if (array[i]>array[i+1]) {
//                    swap(array, i, i+1);
//                }
//            }
//        }
//        return array;
//    }
//
//    public static void swap(int[] arr, int i, int j){
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    public static void main(String[] args) {
//        int[] array = {3, 1, 4, 10, 6, 3, 1, 8, 9, 5, 3};
//        for (int j : sort(array)) {
//            System.out.print(j + " ");
//        }
//    }
//}


public class Code02_BubbleSort {

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 10, 6, 3, 1, 8, 9, 5, 3};
//        int[] array = {3, 1};
        for (int j : sort(array)) {
            System.out.print(j + " ");
        }
    }

    public static int[] sort(int[] array){
        if(array.length <= 1){
            return array;
        }


//        for (int i = 0; i < array.length; i++) {  // 实际上这个实现是选择排序，每次确定剩下的数中最小的数
//            for (int j = i + 1; j < array.length; j++) {  // int j = i + 1这一步其实就是说明前面的已经排好了
//                if (array[i] > array[j]) {
//                    swap(array, i, j);
//                }
//            }
//        }

//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array.length - i - 1; j++) { // 后面的已经排好了
//                if (array[j] > array[j+1]) {
//                    swap(array, j, j+1);  // 冒泡排序只在剩下的里面排
//                }
//            }
//        }
        return array;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
