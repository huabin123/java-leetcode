package com.huabin.algorithm.primary;

/**
 * @Author huabin
 * @DateTime 2022-06-26 22:16
 * @Desc 有序数组中寻找n&&对数器&&随机数组生成器
 */
public class Code04_duishuqi {

    /**
     * @Author huabin
     * @Desc 数组生成器
     * @DateTime 2022/6/26 22:25
     * @param maxNum 数组中最大的数
     * @param maxLen 数组最大长度
     * @Return int[]
     */
    private static int[] genRandomArr(int maxNum, int maxLen) {
        int len = (int) (Math.random() * maxLen);
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = (int) (Math.random() * maxNum);
        }
        return ints;
    }

    private static int[] copyArray(int[] arr){
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    /**
     * @Author huabin
     * @Desc 判断数组是否有序
     * @DateTime 2022/6/26 23:39
     * @param arr
     * @Return boolean
     */
    private static boolean isSortedArray(int[] arr){
        if (arr.length == 0) {
            return true;
        }
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<maxValue) {
                return false;
            }
            maxValue = arr[i];
        }
        return true;
    }

    public static void main(String[] args) {
        int maxNum = 100;
        int maxLen = 100;
        int testTime = 1000;

        for (int i = 0; i < testTime; i++) {
            int[] arr = genRandomArr(maxNum, maxLen);
            int[] copyArray = copyArray(arr);
            Code03_InsertSort.sort(arr);
            if (!isSortedArray(arr)) {
                // 排序失败打印出原始数组
                for (int i1 = 0; i1 < copyArray.length; i1++) {
                    System.out.print(copyArray[i1]+" ");
                }
                System.out.println();
                System.out.println("插入排序出错");
                break;
            }

        }

    }

}
