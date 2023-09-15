//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重
//叠 。
//
//
//
// 示例 1:
//
//
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
//
//
// 示例 2:
//
//
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
//
//
// 示例 3:
//
//
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
//
//
//
//
// 提示:
//
//
// 1 <= intervals.length <= 10⁵
// intervals[i].length == 2
// -5 * 10⁴ <= starti < endi <= 5 * 10⁴
//
//
// Related Topics 贪心 数组 动态规划 排序 👍 1039 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.Arrays;

public class NonOverlappingIntervals{
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            // 按左边排序
            Arrays.sort(intervals, (a, b) -> {
                return Integer.compare(a[0], b[0]);
            });
            int count = 1;  // 不重叠区间的数量
            for (int i = 1; i < intervals.length; i++) {
                // 检查当前区间的左边界是否小于前一个区间的右边界。
                // 如果小于，说明当前区间与前一个区间重叠了，需要进行调整以确保不重叠。
                if (intervals[i][0] < intervals[i - 1][1]) {
                    // 如果重叠，将当前区间的右边界调整为前一个区间的右边界和当前区间右边界的较小值（这是为了尽量减小右边界，以便容纳更多的区间），然后继续遍历下一个区间
                    intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
                } else {
                    count++;
                }
            }
            return intervals.length - count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
