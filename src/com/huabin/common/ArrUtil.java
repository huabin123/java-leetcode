package com.huabin.common;

public class ArrUtil {

    /**
     * @Author huabin
     * @Desc 数组生成器
     * @DateTime 2022/6/26 22:25
     * @param maxNum 数组中最大的数
     * @param maxLen 数组最大长度
     * @Return int[]
     */
    public static int[] genRandomArr(int maxNum, int maxLen) {
        int len = (int) (Math.random() * maxLen);
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = (int) (Math.random() * maxNum);
        }
        return ints;
    }

}
