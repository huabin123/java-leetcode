//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2101 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals{
    public static void main(String[] args) {
         Solution solution = new MergeIntervals().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     时间复杂度 ： O(NlogN) 排序需要O(NlogN)
     空间复杂度 ： O(logN)  java 的内置排序是快速排序 需要 O(logN)空间

     */
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> res = new LinkedList<>();
            //按照左边界排序
            Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
            //initial start 是最小左边界
            int start = intervals[0][0];
            int rightmostRightBound = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                //如果左边界大于最大右边界
                if (intervals[i][0] > rightmostRightBound) {
                    //加入区间 并且更新start
                    res.add(new int[]{start, rightmostRightBound});
                    start = intervals[i][0];
                    rightmostRightBound = intervals[i][1];
                } else {
                    //更新最大右边界
                    rightmostRightBound = Math.max(rightmostRightBound, intervals[i][1]);
                }
            }
            res.add(new int[]{start, rightmostRightBound});
            return res.toArray(new int[res.size()][]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}