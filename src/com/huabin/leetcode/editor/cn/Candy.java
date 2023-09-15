//n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
//
// 你需要按照以下要求，给这些孩子分发糖果：
//
//
// 每个孩子至少分配到 1 个糖果。
// 相邻两个孩子评分更高的孩子会获得更多的糖果。
//
//
// 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
//
//
//
// 示例 1：
//
//
//输入：ratings = [1,0,2]
//输出：5
//解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
//
//
// 示例 2：
//
//
//输入：ratings = [1,2,2]
//输出：4
//解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
//
//
//
// 提示：
//
//
// n == ratings.length
// 1 <= n <= 2 * 10⁴
// 0 <= ratings[i] <= 2 * 10⁴
//
//
// Related Topics 贪心 数组 👍 1329 👎 0


package com.huabin.leetcode.editor.cn;
public class Candy{
    public static void main(String[] args) {
        Solution solution = new Candy().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 分两个阶段
         * 1、起点下标1 从左往右，只要 右边 比 左边 大，右边的糖果=左边 + 1
         * 2、起点下标 ratings.length - 2 从右往左， 只要左边 比 右边 大，此时 左边的糖果应该 取本身的糖果数（符合比它左边大）
         *    和 右边糖果数 + 1 二者的最大值，这样才符合 它比它左边的大，也比它右边大
         */
        public int candy(int[] ratings) {
            int len = ratings.length;
            int[] candyVec = new int[len];
            candyVec[0] = 1;
            for (int i = 1; i < len; i++) {
                candyVec[i] = ratings[i] > ratings[i - 1] ? candyVec[i - 1] + 1 : 1;
            }
            for (int i = len - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
                }
            }
            int ans = 0;
            for (int i = 0; i < len; i++) {
                ans += candyVec[i];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
