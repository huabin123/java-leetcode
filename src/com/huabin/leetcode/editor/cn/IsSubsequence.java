//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而
//"aec"不是）。
//
// 进阶：
//
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
//码？
//
// 致谢：
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
//
//
//
// 示例 1：
//
//
//输入：s = "abc", t = "ahbgdc"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "axc", t = "ahbgdc"
//输出：false
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 100
// 0 <= t.length <= 10^4
// 两个字符串都只由小写字符组成。
//
//
// Related Topics 双指针 字符串 动态规划 👍 943 👎 0


package com.huabin.leetcode.editor.cn;
public class IsSubsequence{
    public static void main(String[] args) {
        Solution solution = new IsSubsequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 这道题其实就是最长公共子序列，只不过这里的s不能减只能减t
        public boolean isSubsequence(String s, String t) {
            int length1 = s.length();
            int length2 = t.length();
            int[][] dp = new int[length1 + 1][length2 + 1];
            for (int i = 1; i <= length1; i++) {
                for (int j = 1; j <= length2; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            return dp[length1][length2] == length1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
