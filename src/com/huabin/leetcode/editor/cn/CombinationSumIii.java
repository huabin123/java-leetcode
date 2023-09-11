//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
//
//
// 只使用数字1到9
// 每个数字 最多使用一次
//
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
//
//
//
// 示例 1:
//
//
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。
//
// 示例 2:
//
//
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。
//
// 示例 3:
//
//
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
//
//
//
//
// 提示:
//
//
// 2 <= k <= 9
// 1 <= n <= 60
//
//
// Related Topics 数组 回溯 👍 750 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIii{
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
        System.out.println(solution.combinationSum3(2, 4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 本题就是在[1,2,3,4,5,6,7,8,9]这个集合中找到和为n的k个数的组合。
        // 本题k相当于树的深度，9（因为整个集合就是9个数）就是树的宽度。
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            backTracking(n, k, 1, 0);
            return result;
        }

        /**
         * 确定递归函数参数和返回值
         * 参数：path：路径，result：结果集，符合条件的路径 定义为类成员变量，不需要传进来
         * k：k个数，n：和为n，sum：已经收集的元素的和，startIndex：下一层for循环搜索开始的位置
         * @param targetSum 目标值
         * @param k k个数
         * @param startIndex 下一层for循环搜索开始的位置
         * @param sum 其实这里sum这个参数也可以省略，每次targetSum减去选取的元素数值，然后判断如果targetSum为0了，说明收集到符合条件的结果了，我这里为了直观便于理解，还是加一个sum参数。
         */
        private void backTracking(int targetSum, int k, int startIndex, int sum) {
            // 减枝
            if (sum > targetSum) {
                return;
            }

            // 确定终止条件，k其实就已经限制树的深度，因为就取k个元素，树再往下深了没有意义。
            // 所以如果path.size() 和 k相等了，就终止。
            if (path.size() == k) {
                if (sum == targetSum) result.add(new ArrayList<>(path));
                return;
            }

            // 减枝 9 - (k - path.size()) + 1，k - path.size()为剩下要的数量，再往9 - (k - path.size()) + 1右边取就不够剩下的数量了
            for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
                path.add(i);
                sum += i;
                backTracking(targetSum, k, i + 1, sum);
                //回溯
                path.removeLast();
                //回溯
                sum -= i;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
