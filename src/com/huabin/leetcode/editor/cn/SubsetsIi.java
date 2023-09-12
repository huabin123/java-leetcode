//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
//
//
// Related Topics 位运算 数组 回溯 👍 1151 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsIi{
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used;
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums.length == 0) {
                result.add(path);
                return result;
            }
            Arrays.sort(nums);
            used = new boolean[nums.length];
            this.subsetsWithDupHelper(nums, 0);
            return result;
        }

        private void subsetsWithDupHelper(int[] nums, int startIndex) {
            result.add(new ArrayList<>(path));
            if (startIndex >= nums.length) {
                return;
            }
            for (int i = startIndex; i < nums.length; i++) {
                // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
                // used[i - 1] == false，说明同一树层candidates[i - 1]使用过，因为上一个是被回溯回来的，执行了used[i] = false
                // 而我们要对同一树层使用过的元素进行跳过
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                subsetsWithDupHelper(nums, i + 1);
                path.removeLast();
                used[i] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
