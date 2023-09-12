//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
//和 "192.168@1.1" 是 无效 IP 地址。
//
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
//
//
// 示例 2：
//
//
//输入：s = "0000"
//输出：["0.0.0.0"]
//
//
// 示例 3：
//
//
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 20
// s 仅由数字组成
//
//
// Related Topics 字符串 回溯 👍 1303 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses{
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new ArrayList<>();
        public List<String> restoreIpAddresses(String s) {
            // 有效的ip最多12位
            if (s.length() > 12) {
                return result;
            }
            this.backTracking(s, 0, 0);
            return result;
        }

        /**
         *
         * @param s
         * @param startIndex
         * @param pointNum 逗点的数量
         */
        private void backTracking(String s, int startIndex, int pointNum) {
            if (pointNum == 3) {
                if(this.isValid(s, startIndex, s.length() - 1)){
                    result.add(s);
                }
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                if (this.isValid(s, startIndex, i)) {
                    s = s.substring(0, i + 1) + "." + s.substring(i + 1);    //在str的后⾯插⼊⼀个逗点
                    pointNum++;
                    backTracking(s, i + 2, pointNum);
                    pointNum--;
                    s = s.substring(0, i + 1) + s.substring(i + 2);// 回溯删掉逗点
                } else {
                    break;
                }
            }
        }

        /**
         * 判断s在左闭右闭区间[startIndex, endIndex]所组成的数组是否合法
         * 1、0开头的数字不合法
         * 2、遇到⾮数字字符不合法
         * 3、如果⼤于255了不合法
         * @param s
         * @param startIndex
         * @param endIndex
         * @return
         */
        private boolean isValid(String s, int startIndex, int endIndex) {
            if (startIndex > endIndex) {
                return false;
            }
            if (s.charAt(startIndex) == '0' && startIndex != endIndex) {
                return false;
            }
            int num = 0;
            for (int i = startIndex; i <= endIndex; i++) {
                if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                    return false;
                }
                num = num * 10 + (s.charAt(i) - '0');
                if (num > 255) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
