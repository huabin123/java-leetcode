//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//
//
//
// 示例 1:
//
// 输入: [7,5,6,4]
//输出: 5
//
//
//
// 限制：
//
// 0 <= 数组长度 <= 50000
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 912 👎 0


package com.huabin.lcof.leetcode.editor.cn;

public class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        System.out.println(solution.reversePairs(new int[]{7, 3, 2, 6, 0, 1, 5, 4, 7, 9, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums, tmp;

        public int reversePairs(int[] nums) {
            this.nums = nums;
            tmp = new int[nums.length];
            return mergeSort(0, nums.length - 1);
        }

        private int mergeSort(int l, int r) {
            // 终止条件
            if (l >= r) return 0;
            // 递归划分
            int m = (l + r) / 2;
            int res = mergeSort(l, m) + mergeSort(m + 1, r);
            // 合并阶段
            int i = l, j = m + 1;
            for (int k = l; k <= r; k++)
                tmp[k] = nums[k];
            for (int k = l; k <= r; k++) {
                if (i == m + 1)
                    nums[k] = tmp[j++];
                else if (j == r + 1 || tmp[i] <= tmp[j])
                    nums[k] = tmp[i++];
                else {
                    nums[k] = tmp[j++];
                    res += m - i + 1; // 统计逆序对 当前i的比j大，那么i后面的所有数字都比j大
                }
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
