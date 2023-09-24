//给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 10⁹ + 7 取模。
//
//
//
// 示例 1：
//
//
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//rabbbit
//rabbbit
//rabbbit
//
// 示例 2：
//
//
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
//
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 1000
// s 和 t 由英文字母组成
//
//
// Related Topics 字符串 动态规划 👍 1138 👎 0


package com.huabin.leetcode.editor.cn;
public class DistinctSubsequences{
    public static void main(String[] args) {
        Solution solution = new DistinctSubsequences().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            for (int i = 0; i < s.length() + 1; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i < s.length() + 1; i++) {
                for (int j = 1; j < t.length() + 1; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[s.length()][t.length()];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
