//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
//
//
// 示例 2：
//
//
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 15
// -100 <= nums[i] <= 100
//
//
// Related Topics 位运算 数组 哈希表 回溯 👍 719 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.*;

public class NonDecreasingSubsequences{
    public static void main(String[] args) {
        Solution solution = new NonDecreasingSubsequences().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used;
        public List<List<Integer>> findSubsequences(int[] nums) {
            // 要注意这一题不能对原数组排序
            used = new boolean[nums.length];
            this.findSubsequencesHelper(nums, 0);
            return result;
        }

        private void findSubsequencesHelper(int[] nums, int startIndex) {
            if (path.size() > 1) {  // 本题要求子序列的长度至少为2
                result.add(new ArrayList<>(path));
                // 这里不要return，因为需要除了叶子结点还要收集其他节点
            }
            Set<Integer> set = new HashSet<>();  // 使用set对本层进行去重
            for (int i = startIndex; i < nums.length; i++) {
                if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || set.contains(nums[i])) {
                    continue;
                }
                set.add(nums[i]);
                path.add(nums[i]);
                findSubsequencesHelper(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
