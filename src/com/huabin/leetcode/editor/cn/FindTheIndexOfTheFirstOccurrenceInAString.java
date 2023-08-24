//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
//
//
// 示例 2：
//
//
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= haystack.length, needle.length <= 10⁴
// haystack 和 needle 仅由小写英文字符组成
//
//
// Related Topics 双指针 字符串 字符串匹配 👍 1967 👎 0


package com.huabin.leetcode.editor.cn;

public class FindTheIndexOfTheFirstOccurrenceInAString{
    public static void main(String[] args) {
        Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        solution.strStr("aabaabaafa", "aabaaf");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            // KMP算法
            // 1、获取next数组 2、使用next数组匹配
            int[] next = new int[needle.length()];
            getNext(next, needle);
            int j = -1;
            for (int i = 0; i < haystack.length(); i++) {
                while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                    j = next[j];
                }
                if (haystack.charAt(i) == needle.charAt(j + 1)) {
                    j++;
                }
                if (j == needle.length() - 1) {
                    return (i - needle.length() + 1);
                }
            }

            return -1;
        }

        // 构造next数组
        // 分为三步
        // 1、初始化
        // 2、处理前后缀不相同的情况
        // 3、处理前后缀相同的情况
        public void getNext(int[] next, String s) {
            int j = -1;  // 关键就是j，j就是前缀的长度
            next[0] = j;
            for (int i = 1; i < s.length(); i++) {
                while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                    // 不匹配回退
                    j = next[j];
                }

                if (s.charAt(i) == s.charAt(j + 1)) {
                    // 能匹配就和i一起往前走
                    j++;
                }
                // 别忘了给next数组赋值
                next[i] = j;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
