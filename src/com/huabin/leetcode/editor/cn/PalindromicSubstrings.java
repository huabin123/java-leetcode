//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
//
// 回文字符串 是正着读和倒过来读一样的字符串。
//
// 子字符串 是字符串中的由连续字符组成的一个序列。
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
//
//
//
// 示例 1：
//
//
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
//
//
// 示例 2：
//
//
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 由小写英文字母组成
//
//
// Related Topics 字符串 动态规划 👍 1242 👎 0


package com.huabin.leetcode.editor.cn;
public class PalindromicSubstrings{
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 动态规划
     * 这题要注意遍历顺序，根根据递推公式：dp[i + 1][j - 1]，确定遍历顺序为从下到上，从左到右
     */
    class Solution {
        public int countSubstrings(String s) {
            char[] chars = s.toCharArray();
            int len = chars.length;
            boolean[][] dp = new boolean[len][len];
            int result = 0;
            for (int i = len - 1; i >= 0; i--) {
                for (int j = i; j < len; j++) {
                    if (chars[i] == chars[j]) {
                        if (j - i <= 1) { // 情况一 和 情况二
                            result++;
                            dp[i][j] = true;
                        } else if (dp[i + 1][j - 1]) { //情况三
                            result++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
