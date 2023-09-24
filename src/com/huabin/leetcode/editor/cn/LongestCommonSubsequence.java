//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//
//
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
//
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
//
//
//
// 示例 1：
//
//
//输入：text1 = "abcde", text2 = "ace"
//输出：3
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
//
//
// 示例 2：
//
//
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
//
//
// 示例 3：
//
//
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
//
//
//
//
// 提示：
//
//
// 1 <= text1.length, text2.length <= 1000
// text1 和 text2 仅由小写英文字符组成。
//
//
// Related Topics 字符串 动态规划 👍 1432 👎 0


package com.huabin.leetcode.editor.cn;
public class LongestCommonSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            // char[] char1 = text1.toCharArray();
            // char[] char2 = text2.toCharArray();
            // 可以在一開始的時候就先把text1, text2 轉成char[]，之後就不需要有這麼多爲了處理字串的調整
            // 就可以和卡哥的code更一致

            int[][] dp = new int[text1.length() + 1][text2.length() + 1]; // 先对dp数组做初始化操作
            for (int i = 1; i <= text1.length(); i++) {
                char char1 = text1.charAt(i - 1);
                for (int j = 1; j <= text2.length(); j++) {
                    char char2 = text2.charAt(j - 1);
                    if (char1 == char2) { // 开始列出状态转移方程
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[text1.length()][text2.length()];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
