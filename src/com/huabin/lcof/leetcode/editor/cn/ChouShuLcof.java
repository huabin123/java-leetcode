//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//
//
//
// 示例:
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明:
//
//
// 1 是丑数。
// n 不超过1690。
//
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 403 👎 0


package com.huabin.lcof.leetcode.editor.cn;

public class ChouShuLcof {
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
        System.out.println(solution.nthUglyNumber(1690));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 普通解法,会超时
     */
//    public class Solution {
//        public int nthUglyNumber(int n) {
//            // 防止特殊输入
//            if (n <= 0) {
//                return 0;
//            }
//            int count = 0;
//            int base = 0;
//            while (count != n) {
//                base++;
//                if (isUglyNumber(base)) {
//                    count++;
//                }
//            }
//            return base;
//        }
//
//        boolean isUglyNumber(int number) {
//            while (number % 2 == 0) {
//                number /= 2;
//            }
//            while (number % 3 == 0) {
//                number /= 3;
//            }
//            while (number % 5 == 0) {
//                number /= 5;
//            }
//            return number == 1;
//        }
//    }

    /**
     * 动态规划
     */
    class Solution {
        public int nthUglyNumber(int n) {
            int a = 0, b = 0, c = 0;
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
                dp[i] = Math.min(Math.min(n2, n3), n5);
                if (dp[i] == n2) a++;
                if (dp[i] == n3) b++;
                if (dp[i] == n5) c++;
            }
            return dp[n - 1];
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
