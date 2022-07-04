package com.huabin.algorithm.primary;

/**
 * @Author huabin
 * @DateTime 2022-06-29 12:36
 * @Desc 有序数组中找到>=num最左的位置
 */
public class Code06_BSNearLeft {

    public static int mostLefNoLessNum(int[] arr, int num){
        int l = 0;
        int r = arr.length - 1;
        int ans = -1;
        while (l<=r) {
            int mid = (l + r) / 2;
            if (arr[mid]>num) {
                r = mid - 1;
                ans = mid;
            }else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            int[] ints = Code04_duishuqi.genRandomArr(10, 20);
            Code03_InsertSort.sort(ints);
            for (int i1 = 0; i1 < ints.length; i1++) {
                System.out.print(ints[i1]+" ");
            }
            System.out.println();
            System.out.println(mostLefNoLessNum(ints, 5));
        }

    }

}
