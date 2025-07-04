//给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
//
// 注意：如果对空文本输入退格字符，文本继续为空。
//
//
//
// 示例 1：
//
//
//输入：s = "ab#c", t = "ad#c"
//输出：true
//解释：s 和 t 都会变成 "ac"。
//
//
// 示例 2：
//
//
//输入：s = "ab##", t = "c#d#"
//输出：true
//解释：s 和 t 都会变成 ""。
//
//
// 示例 3：
//
//
//输入：s = "a#c", t = "b"
//输出：false
//解释：s 会变成 "c"，但 t 仍然是 "b"。
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 200
// s 和 t 只含有小写字母以及字符 '#'
//
//
//
//
// 进阶：
//
//
// 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
//
//
// Related Topics 栈 双指针 字符串 模拟 👍 820 👎 0


package com.huabin.leetcode.editor.cn;
public class BackspaceStringCompare{
    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompare().new Solution();
        solution.backspaceCompare("ab#c", "ad#c");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 关键点是逆序，定义需要跳过的步数
        public boolean backspaceCompare(String s, String t) {
            int skipS = 0, skipT = 0;
            int i = s.length() - 1, j = t.length() - 1;
            while (i >= 0 || j >= 0) {
                while (i >= 0) {
                    if (s.charAt(i) == '#') {
                        skipS++;
                        i--;
                    } else if (skipS > 0) {
                        skipS--;
                        i--;
                    } else {
                        break;
                    }
                }
                while (j >= 0) {
                    if (t.charAt(j) == '#') {
                        skipT++;
                        j--;
                    } else if (skipT > 0) {
                        skipT--;
                        j--;
                    } else {
                        break;
                    }
                }
                if (i >= 0 && j >= 0) {
                    if (s.charAt(i) != t.charAt(j)) {
                        return false;
                    }
                } else {
                    if (i >= 0 || j >= 0) {
                        return false;
                    }
                }
                i--;
                j--;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
