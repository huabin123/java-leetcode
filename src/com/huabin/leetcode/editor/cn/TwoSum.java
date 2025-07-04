//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 10⁴
// -10⁹ <= nums[i] <= 10⁹
// -10⁹ <= target <= 10⁹
// 只会存在一个有效答案
//
//
//
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？
//
// Related Topics 数组 哈希表 👍 17519 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum{
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] res = solution.twoSum(new int[]{3, 2, 4}, 6);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();  // key存放元素，value存放下标。为什么key存放元素，因为要判断元素是否存在
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i],i);
            }
            int num = 0;
            for (int i = 0; i < nums.length; i++) {
                num = target - nums[i];
                if (map.containsKey(num) && map.get(num) != i) {  // map.get(num) != i注意这个条件
                    return new int[]{i, map.get(num)};
                }
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
