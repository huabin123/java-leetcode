//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用 一次 。
//
// 注意：解集不能包含重复的组合。
//
//
//
// 示例 1:
//
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//
// 示例 2:
//
//
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//]
//
//
//
// 提示:
//
//
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
//
//
// Related Topics 数组 回溯 👍 1440 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(solution.combinationSum2(candidates, 8));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used;
        int sum = 0;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            used = new boolean[candidates.length];
            // 加标志数组，用来辅助判断同层节点是否已经遍历
            Arrays.fill(used, false);
            // 为了将重复的数字都放到一起，所以先进行排序
            Arrays.sort(candidates);
            backTracking(candidates, target, 0);
            return ans;
        }

        private void backTracking(int[] candidates, int target, int startIndex) {
            if (sum == target) {
                ans.add(new ArrayList(path));
            }
            for (int i = startIndex; i < candidates.length; i++) {
                if (sum + candidates[i] > target) {  // 剪枝
                    break;
                }
                // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
                // 横向不能重复使用，但是纵向可以
                if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                sum += candidates[i];
                path.add(candidates[i]);
                // 每个节点仅能选择一次，所以从下一位开始
                backTracking(candidates, target, i + 1);
                used[i] = false;
                sum -= candidates[i];
                path.removeLast();
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
