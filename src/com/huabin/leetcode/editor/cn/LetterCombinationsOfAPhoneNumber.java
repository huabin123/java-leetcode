//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
// Related Topics 哈希表 字符串 回溯 👍 2058 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("222"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<String> res = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return res;
            }
            // 为了让"abc"和键"2"对应，添加了两个空串
            String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            this.backTracking(digits, numString, 0);
            return res;
        }

        StringBuilder temp = new StringBuilder();

        /**
         * 本题的回溯参数不需要startIndex，因为是不同的集合求组合，所以只要记住digits的下标就行了
         *
         * @param digits
         * @param numString
         * @param num
         */
        private void backTracking(String digits, String[] numString, int num) {
            // 终止条件
            if (num == digits.length()) {
                res.add(temp.toString());
                return;
            }
            // num所在的键表示的字符串，如num 为0，则str表示2对应的 abc
            String str = numString[digits.charAt(num) - '0'];
            for (int i = 0; i < str.length(); i++) {
                temp.append(str.charAt(i));
                backTracking(digits, numString, num + 1);
                temp.deleteCharAt(temp.length() - 1);  // 不符合，回溯
            }
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)

}
