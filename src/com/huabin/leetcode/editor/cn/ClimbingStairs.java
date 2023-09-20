//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//
//
// 示例 1：
//
//
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶
//
// 示例 2：
//
//
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
//
//
//
//
// 提示：
//
//
// 1 <= n <= 45
//
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3251 👎 0


package com.huabin.leetcode.editor.cn;
public class ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
//        public int climbStairs(int n) {
//            if (n <= 1) {
//                return n;
//            }
//            int[] dp = new int[n + 1];
//            dp[1] = 1;
//            dp[2] = 2;
//            for (int i = 3; i <= n; i++) {
//                dp[i] = dp[i - 1] + dp[i - 2];
//            }
//            return dp[n];
//        }
//    }

    /**
     * 这个题还能稍作修改能转化成一个完全背包问题
     * 有n阶台阶，一次可以上m阶，问跳到顶楼有几种方法（排列）
     */
    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            int m = 2; //有兩個物品：itme1重量爲一，item2重量爲二
            dp[0] = 1;

            for (int i = 1; i <= n; i++) { // 遍历背包
                for (int j = 1; j <= m; j++) { //遍历物品
                    if (i >= j)  //當前的背包容量 大於 物品重量的時候，我們才需要記錄當前的這個裝得方法（方法數+）
                        dp[i] += dp[i - j];
                }
            }

            return dp[n];
        }
    }



    //leetcode submit region end(Prohibit modification and deletion)

}
