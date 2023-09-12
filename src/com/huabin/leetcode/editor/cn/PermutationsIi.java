//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1454 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi{
    public static void main(String[] args) {
         Solution solution = new PermutationsIi().new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 3}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used;
        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums.length == 0) {
                return result;
            }
            used = new boolean[nums.length];
            Arrays.sort(nums);
            this.permuteUniqueHelper(nums);
            return result;
        }

        private void permuteUniqueHelper(int[] nums) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                // 这里要注意同一个树枝上，同一个元素也不能重复使用,正是有了这行代码我们才知道取过1了，就要从剩下的1，2里面取
                if (!used[i]) {
                    path.add(nums[i]);
                    used[i] = true;
                    permuteUniqueHelper(nums);
                    path.remove(path.size() - 1);
                    used[i] = false;
                }

            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}