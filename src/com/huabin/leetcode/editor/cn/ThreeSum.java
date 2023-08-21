////给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且
//不重
////复的三元组。
////
//// 注意：答案中不可以包含重复的三元组。
////
////
////
//// 示例 1：
////
////
////输入：nums = [-1,0,1,2,-1,-4]
////输出：[[-1,-1,2],[-1,0,1]]
////
////
//// 示例 2：
////
////
////输入：nums = []
////输出：[]
////
////
//// 示例 3：
////
////
////输入：nums = [0]
////输出：[]
////
////
////
////
//// 提示：
////
////
//// 0 <= nums.length <= 3000
//// -10⁵ <= nums[i] <= 10⁵
////
//// Related Topics 数组 双指针 排序 👍 4775 👎 0
//


package com.huabin.leetcode.editor.cn;

import java.util.*;

public class ThreeSum{
    public static void main(String[] args) {
         Solution solution = new ThreeSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 哈希法
        // 时间复杂度: O(n^2)
        // 空间复杂度: O(n)，额外的 set 开销
        public List<List<Integer>> threeSum1(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums); // 先将数组排序

            // 为什么这里的循环结束条件是nums.length - 2?
            // 1、最少需要三个元素才能组成一个有效的三元组。如果数组长度小于 3，无法找到任何三元组，因此循环的结束条件必须在 nums.length - 2 之前，否则在数组长度不足 3 的情况下会导致访问越界。
            // 2、使用双指针的方法来寻找三元组，固定一个元素作为基准，然后在基准元素之后的区间内进行双指针遍历。因此，在最后两个元素之后是无法找到合适的三元组的，所以循环的结束条件要留出至少两个位置用于双指针的操作。
            for (int i = 0; i < nums.length - 2; i++) {
                // 接下来要选取基准值，满足什么条件能作为基准值？
                // 1、i == 0：这部分表示在数组的第一个位置，因为第一个元素没有前一个元素，所以无法判断是否重复，所以可以直接考虑这个元素。
                // 2、nums[i] != nums[i - 1]：这部分是在数组的其他位置，用于判断当前元素是否与前一个元素重复。如果当前元素与前一个元素不同，说明当前元素是一个新的不同元素，可以将其考虑为基准元素。
                if (i == 0 || (nums[i] != nums[i - 1])) {
                    int target = -nums[i];  // 要找后面有没有和为target的两个数
                    Set<Integer> seen = new HashSet<>();  // 哈希需要定义在这里

                    for (int j = i + 1; j < nums.length; j++) {
                        int complement = target - nums[j];

                        if (seen.contains(complement)) {
                            result.add(Arrays.asList(nums[i], nums[j], complement));  // 使用Arrays.asList，组合三个数字
                            // 找到了剩下的数还需要跳过接下来重复的数
                            while (j < nums.length - 1 && nums[j] == nums[j + 1]) {  // 为了确保在循环内的操作（nums[j + 1]）不会超出数组的边界，需要是j < nums.length - 1而不是j < nums.length
                                j++; // 跳过重复元素
                            }
                        }

                        seen.add(nums[j]);
                    }
                }
            }

            return result;
        }

        // 三指针法
        // 时间复杂度: O(n^2),但是比上面快，这个方法能剪枝
        // 空间复杂度: O(1)
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return result;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 定义左右指针
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // left,right去重
                        while (left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while (left > right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;  // 不要忘了这两步，不然循环出不来
                        left++;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
