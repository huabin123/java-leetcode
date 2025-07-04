//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100]
//
// 示例 2：
//
//
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 已按 非递减顺序 排序
//
//
//
//
// 进阶：
//
//
// 请你设计时间复杂度为 O(n) 的算法解决本问题
//
// Related Topics 数组 双指针 排序 👍 612 👎 0


package com.huabin.leetcode.editor.cn;
public class SquaresOfASortedArray{
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            // 20250612
            // 使用头尾指针


            int l = 0;
            int r = nums.length - 1;
            int[] result = new int[nums.length];
            int j = nums.length - 1;
            while (l <= r) { // 头尾指针碰撞作为终止条件
                if (nums[l] * nums[l] > nums[r] * nums[r]) {
                    result[j--] = nums[l] * nums[l++];
                }else {
                    result[j--] = nums[r] * nums[r--];
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
