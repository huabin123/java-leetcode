//给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
//
// 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那
//么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,5,4,7]
//输出：3
//解释：最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
//
//
// 示例 2：
//
//
//输入：nums = [2,2,2,2,2]
//输出：1
//解释：最长连续递增序列是 [2], 长度为1。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -10⁹ <= nums[i] <= 10⁹
//
//
// Related Topics 数组 👍 419 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.Arrays;

public class LongestContinuousIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestContinuousIncreasingSubsequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1.dp[i] 代表当前下标最大连续值
         * 2.递推公式 if（nums[i+1]>nums[i]） dp[i+1] = dp[i]+1
         * 3.初始化 都为1
         * 4.遍历方向，从其那往后
         * 5.结果推导 。。。。
         *
         * @param nums
         * @return
         */
        public int findLengthOfLCIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int res = 1;
            //可以注意到，這邊的 i 是從 0 開始，所以會出現和卡哥的C++ code有差異的地方，在一些地方會看到有 i + 1 的偏移。
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i-1]) {
                    dp[i] = dp[i-1] + 1;
                }
                res = res > dp[i] ? res : dp[i];
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
