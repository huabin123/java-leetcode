//有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
//
// 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
//
//
// 如果 x == y，那么两块石头都会被完全粉碎；
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
//
//
// 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
//
//
//
// 示例 1：
//
//
//输入：stones = [2,7,4,1,8,1]
//输出：1
//解释：
//组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
//组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
//组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
//组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
//
//
// 示例 2：
//
//
//输入：stones = [31,26,33,21,40]
//输出：5
//
//
//
//
// 提示：
//
//
// 1 <= stones.length <= 30
// 1 <= stones[i] <= 100
//
//
// Related Topics 数组 动态规划 👍 757 👎 0


package com.huabin.leetcode.editor.cn;
public class LastStoneWeightIi{
    public static void main(String[] args) {
        Solution solution = new LastStoneWeightIi().new Solution();
        int[] stones = new int[]{2, 7, 4, 1, 8, 1, 100};
        System.out.println(solution.lastStoneWeightII(stones));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int sum = 0;
            for (int i : stones) {
                sum += i;
            }
            int target = sum >> 1;
            //初始化dp数组
            // dp[j]表示容量（这里说容量更形象，其实就是重量）为j的背包，最多可以背最大重量为dp[j]。
            int[] dp = new int[target + 1];
            for (int i = 0; i < stones.length; i++) {
                //采用倒序
                for (int j = target; j >= stones[i]; j--) {
                    //两种情况，要么放，要么不放
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }
            return sum - 2 * dp[target];  // 这里其实是dp[i]最多能装多少
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
