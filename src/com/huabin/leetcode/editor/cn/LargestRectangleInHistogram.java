//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
// 示例 1:
//
//
//
//
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
//
//
// 示例 2：
//
//
//
//
//输入： heights = [2,4]
//输出： 4
//
//
//
// 提示：
//
//
// 1 <= heights.length <=10⁵
// 0 <= heights[i] <= 10⁴
//
//
// Related Topics 栈 数组 单调栈 👍 2567 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.Stack;

public class LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int largestRectangleArea(int[] heights) {
            Stack<Integer> st = new Stack<Integer>();

            // 数组扩容，在头和尾各加入一个元素
            // 如果不在头尾加零的话，如果数组本来就是一个单调递增数组，那么就就无法进入heights[i] < heights[st.peek()的条件分支
            int[] newHeights = new int[heights.length + 2];
            newHeights[0] = 0;
            newHeights[newHeights.length - 1] = 0;
            for (int index = 0; index < heights.length; index++) {
                newHeights[index + 1] = heights[index];
            }

            heights = newHeights;

            st.push(0);
            int result = 0;
            // 第一个元素已经入栈，从下标1开始
            for (int i = 1; i < heights.length; i++) {
                // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
                if (heights[i] > heights[st.peek()]) {
                    st.push(i);
                } else if (heights[i] == heights[st.peek()]) {
                    st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                    st.push(i);
                } else {
                    while (heights[i] < heights[st.peek()]) { // 注意是while
                        int mid = st.peek();
                        st.pop();
                        int left = st.peek();
                        int right = i;
                        int w = right - left - 1;
                        int h = heights[mid];
                        result = Math.max(result, w * h);
                    }
                    st.push(i);
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
