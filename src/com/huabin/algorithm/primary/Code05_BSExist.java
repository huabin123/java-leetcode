package com.huabin.algorithm.primary;

import java.util.Collections;

/**
 * @Author huabin
 * @DateTime 2022-06-28 22:32
 * @Desc 有序数组中寻找数字num是否存在
 */
public class Code05_BSExist {

    /**
     * @param arr 有序的数组
     * @param num 需要判断是否存在的数
     * @return
     */
    private static boolean find(int[] arr, int num){
        if (arr.length==0) {
            return false;
        }

        int l = 0;
        int r = arr.length - 1;
        while (l <= r){
            int i = (l+r) / 2;
            int mid = arr[i];
            if (mid == num) {
                return true;
            } else if (mid > num) {
                r = i - 1;  // 注意这里要使用下标，不用用错成了mid
            }else {
                l = i + 1;
            }
        }
        return false;
    }

    private static boolean findStupid(int[] arr, int num){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int maxLen = 10;
        int maxNum = 10;
        int testTimes = 1000;
        int num = 8;
        for (int i = 0; i < testTimes; i++) {
            int[] ints = Code04_duishuqi.genRandomArr(maxNum, maxLen);
            for (int i1 = 0; i1 < ints.length; i1++) {
                System.out.print(ints[i1]+" ");
            }
            System.out.println();
            Code01_SelectionSort.sort(ints);
            if (find(ints, num)) {
                System.out.println("包含数字");
                for (int i1 = 0; i1 < ints.length; i1++) {
                    System.out.print(ints[i1]+" ");
                }
                System.out.println();
            }
        }



    }


}

