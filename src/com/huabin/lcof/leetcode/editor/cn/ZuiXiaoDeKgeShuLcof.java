//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//
//
// 示例 1：
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//
//
// 示例 2：
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0]
//
//
//
// 限制：
//
//
// 0 <= k <= arr.length <= 10000
// 0 <= arr[i] <= 10000
//
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 504 👎 0


package com.huabin.lcof.leetcode.editor.cn;

import java.util.Arrays;

public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        int[] leastNumbers = solution.getLeastNumbers(new int[]{2, 4, 5, 1, 0, 3, 5}, 7);
        System.out.println(Arrays.toString(leastNumbers));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 快排
     */
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            quickSort(arr, 0, arr.length - 1);
            return Arrays.copyOf(arr, k);
        }

        private void quickSort(int[] arr, int l, int r) {
            // 子数组长度为1时终止递归
            if (l >= r) {
                return;
            }
            // 哨兵划分操作（以arr[l]作为基准数）
            int i = l, j = r;
            while (i < j) {
                while (i < j && arr[j] >= arr[l]) {
                    j--;
                }
                while (i < j && arr[i] <= arr[l]) {
                    i++;
                }
                swap(arr, i, j);  // 这里不交换会一直循环
            }
            swap(arr, i, l);
            // 递归左（右）子数组执行哨兵划分
            quickSort(arr, l, i - 1);
            quickSort(arr, i + 1, r);
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
