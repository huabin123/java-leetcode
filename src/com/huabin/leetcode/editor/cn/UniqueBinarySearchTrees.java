//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：5
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= n <= 19
//
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2359 👎 0


package com.huabin.leetcode.editor.cn;
public class UniqueBinarySearchTrees{
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            //初始化 dp 数组
            int[] dp = new int[n + 1];
            //初始化0个节点和1个节点的情况
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                    //一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
