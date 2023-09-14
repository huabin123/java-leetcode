//给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
//
//
// 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
//
//
// 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
//
// 以这种方式修改数组后，返回数组 可能的最大和 。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,2,3], k = 1
//输出：5
//解释：选择下标 1 ，nums 变为 [4,-2,3] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,-1,0,2], k = 3
//输出：6
//解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
//
//
// 示例 3：
//
//
//输入：nums = [2,-3,-1,5,-4], k = 2
//输出：13
//解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -100 <= nums[i] <= 100
// 1 <= k <= 10⁴
//
//
// Related Topics 贪心 数组 排序 👍 400 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaximizeSumOfArrayAfterKNegations{
    public static void main(String[] args) {
        Solution solution = new MaximizeSumOfArrayAfterKNegations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestSumAfterKNegations(int[] nums, int K) {
            // 第一步：将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
            nums = IntStream.of(nums)
                    .boxed()
                    .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                    .mapToInt(Integer::intValue).toArray();
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                // 第二步：从前向后遍历，遇到负数将其变为正数，同时K--
                if (nums[i] < 0 && K > 0) {
                    nums[i] = -nums[i];
                    K--;
                }
            }
            // 第三步：如果K还大于0，那么反复转变数值最小的元素，将K用完
            if (K % 2 == 1) nums[len - 1] = -nums[len - 1];
            // 第四步：求和
            return Arrays.stream(nums).sum();

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
