//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
// 如果可以，返回 true ；否则返回 false 。
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。
//
//
//
// 示例 1：
//
//
//输入：ransomNote = "a", magazine = "b"
//输出：false
//
//
// 示例 2：
//
//
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
//
//
// 示例 3：
//
//
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
//
//
//
//
// 提示：
//
//
// 1 <= ransomNote.length, magazine.length <= 10⁵
// ransomNote 和 magazine 由小写英文字母组成
//
//
// Related Topics 哈希表 字符串 计数 👍 769 👎 0


package com.huabin.leetcode.editor.cn;
public class RansomNote{
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {
                return false;
            }
            // 在给定字符的情况下，可以通过减去 'a' 或 'A' 的 ASCII 码来获得该字符在数组或映射中的索引，从而实现字符到索引的映射，这种方法在一些情况下非常高效。这在解决类似于字符频率统计、字母异位词判断等问题时是常见的技巧，因为它能够将字符映射到连续的整数范围内，方便数组或者哈希表的使用。
            int[] record = new int[26];
            for (char c : magazine.toCharArray()) {
                record[c - 'a'] += 1;
            }
            for (char c : ransomNote.toCharArray()) {
                record[c - 'a'] -= 1;
            }
            for (int i : record) {
                if (i < 0) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
