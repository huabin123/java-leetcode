//给你一个非负整数数组 nums 和一个整数 target 。
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//
//
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
//
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
//
//
// 示例 2：
//
//
//输入：nums = [1], target = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 20
// 0 <= nums[i] <= 1000
// 0 <= sum(nums[i]) <= 1000
// -1000 <= target <= 1000
//
//
// Related Topics 数组 动态规划 回溯 👍 1746 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetSum{
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(solution.findTargetSumWays(nums, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 动规解法 转化为01背包问题
     *
     * 我们假设P是正子集，N是负子集
     * 例如： 假设nums = [1, 2, 3, 4, 5]，target = 3，一个可能的解决方案是+1-2+3-4+5 = 3
     * 这里正子集P = [1, 3, 5]和负子集N = [2, 4]
     *
     * 公式一：sum = sum(P) + sum(N)
     * 公式二：sum(P) - sum(N) = target
     * 将公式一代入公式二有：sum(P) - (sum - sum(P)) = target
     *      --> sum(P) = (target + sum(nums)) / 2
     *
     * 此时问题就转化为，装满容量为sum(P)的背包，有几种方法。
     *
     * 组合类问题的公式，都是类似这种：dp[j] += dp[j - nums[i]]
     *
     */
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) sum += nums[i];
            //如果target过大 sum将无法满足
            if (target < 0 && sum < -target) return 0;
            if ((target + sum) % 2 != 0) return 0;
            int size = (target + sum) / 2;
            if (size < 0) size = -size;
            int[] dp = new int[size + 1];
            dp[0] = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = size; j >= nums[i]; j--) {
                    dp[j] += dp[j - nums[i]];
//                    for (int i1 : dp) {
//                        System.out.print(i1 + " ");
//                    }
//                    System.out.println("\n");
                }
            }
            return dp[size];
        }
    }


    /**
     * 回溯法，本题可以转变为组合总和问题，能过
     *
     * 我们假设P是正子集，N是负子集
     * 例如： 假设nums = [1, 2, 3, 4, 5]，target = 3，一个可能的解决方案是+1-2+3-4+5 = 3
     * 这里正子集P = [1, 3, 5]和负子集N = [2, 4]
     *
     * 公式一：sum = sum(P) + sum(N)
     * 公式二：sum(P) - sum(N) = target
     * 将公式一代入公式二有：sum(P) - (sum - sum(P)) = target
     *      --> sum(P) = (target + sum(nums)) / 2
     *
     * 由此此问题转化为 在集合nums中找出和为(target + sum(nums)) / 2的组合
     */
//    class Solution {
//
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//
//        public int findTargetSumWays(int[] nums, int target) {
//            int sum = 0;
//            for (int i = 0; i < nums.length; i++) {
//                sum += nums[i];
//            }
//            if (target > sum) {
//                return 0;
//            }
//            if ((target + sum) % 2 > 0) {
//                // 不能有余数，因为sum(P) = (target + sum(nums)) / 2 ，sum(P)要是一个整数
//                return 0;
//            }
//
//            int bagSize = (target + sum) / 2;
//            Arrays.sort(nums);
//            this.backTrack(nums, bagSize, 0, 0);
//            return result.size();
//        }
//
//        private void backTrack(int[] nums, int target, int sum, int startIndex) {
//            if (sum == target) {
//                result.add(path);
//            }
//            for (int i = startIndex; i < nums.length && sum + nums[i] <= target; i++) {
//                sum += nums[i];
//                path.add(nums[i]);
//                backTrack(nums, target, sum, i + 1);
//                sum -= nums[i];
//                path.remove(path.size() - 1);
//            }
//        }
//    }
    //leetcode submit region end(Prohibit modification and deletion)

}
