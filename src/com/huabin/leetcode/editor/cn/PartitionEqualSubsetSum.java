//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//
// 示例 2：
//
//
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
//
//
// Related Topics 数组 动态规划 👍 1884 👎 0


package com.huabin.leetcode.editor.cn;


import java.util.Arrays;

public class PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(solution.canPartition(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
//    // 回溯法，会超时
//    class Solution {
//        public boolean canPartition(int[] nums) {
//            int sum = 0;
//            for (int num : nums) {
//                sum += num;
//            }
//
//            // 如果数组元素和为奇数，无法分割成两个相等的子集
//            if (sum % 2 != 0) {
//                return false;
//            }
//
//            // 排序数组，以便提前剪枝
//            Arrays.sort(nums);
//
//            // 回溯搜索
//            return backtrack(nums, nums.length - 1, sum / 2, 0);
//        }
//
//        private boolean backtrack(int[] nums, int index, int target, int currentSum) {
//            if (currentSum == target) {
//                return true;
//            }
//            if (currentSum > target || index < 0) {
//                return false;
//            }
//
//            // 尝试将当前元素加入子集1或子集2
//            return backtrack(nums, index - 1, target, currentSum) ||
//                    backtrack(nums, index - 1, target, currentSum + nums[index]);
//        }
//    }

    // 动态规划
    class Solution {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            int n = nums.length;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            //总和为奇数，不能平分
            if (sum % 2 != 0) return false;
            int target = sum / 2;
            int[] dp = new int[target + 1];
            for (int i = 0; i < n; i++) {
                for (int j = target; j >= nums[i]; j--) {
                    //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }

                //剪枝一下，每一次完成內層的for-loop，立即檢查是否dp[target] == target，優化時間複雜度（26ms -> 20ms）
                if (dp[target] == target)
                    return true;
            }
            return dp[target] == target;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
