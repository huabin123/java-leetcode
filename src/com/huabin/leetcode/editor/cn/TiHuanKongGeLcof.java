//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//
//
// 示例 1：
//
// 输入：s = "We are happy."
//输出："We%20are%20happy."
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 10000
//
// Related Topics 字符串 👍 540 👎 0


package com.huabin.leetcode.editor.cn;
public class TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            // 双指针法，先把字符串扩容成最终的size，再用一个指针指向新的数组的最后，一个指针指向旧的数组的最后
            // 两个指针同时往前移动，如果旧指针对应的值不是空格，则直接赋值给新指针，如果是空格则依次填充%20，然后指针移动两位
            if (s == null || s.length() == 0) {
                return s;
            }
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {  // 注意这里不能用" "," "是字符串 ''是字符
                    str.append("  ");
                }
            }
            if (str.length() == 0) {
                // 说明没有空字符，直接返回
                return s;
            }
            int left = s.length() - 1;
            s += str.toString();
            int right = s.length() - 1;
            char[] chars = s.toCharArray();
            while (left >= 0) {
                if (chars[left] == ' ') {
                    chars[right--] = '0';
                    chars[right--] = '2';
                    chars[right] = '%';
                } else {
                    chars[right] = chars[left];
                }
                right--;
                left--;
            }
            return new String(chars);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
