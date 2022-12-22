//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//
// 要求时间复杂度为O(n)。
//
//
//
// 示例1:
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 10^5
// -100 <= arr[i] <= 100
//
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
//
//
//
// Related Topics 数组 分治 动态规划 👍 630 👎 0


package com.huabin.lcof.leetcode.editor.cn;

public class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 2, 2, -3, 4, -1, 2, 1, -5, 4, 6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[] f = new int[2];
            f[0] = nums[0];
            int ans = f[0];
            for (int i = 1; i < n; i++) {
                int a = i & 1, b = (i - 1) & 1;
                f[a] = Math.max(nums[i], f[b] + nums[i]);
                ans = Math.max(ans, f[a]);
            }
            return ans;
        }
    }

//    class Solution {
//        public int maxSubArray(int[] nums) {
//            int res = nums[0];
//            for (int i = 1; i < nums.length; i++) {
//                // 将原数组作为dp列表，直接在nums上修改，空间复杂度从O(n)变为O(1)
//                nums[i] += Math.max(nums[i - 1], 0);
//                res = Math.max(res, nums[i]);
//            }
//            return res;
//        }
//    }
    //leetcode submit region end(Prohibit modification and deletion)

}
