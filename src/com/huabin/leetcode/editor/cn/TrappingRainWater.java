//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 1 <= n <= 2 * 10⁴
// 0 <= height[i] <= 10⁵
//
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4739 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.Stack;

public class TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        int[] rain = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(rain));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 暴力解法，从列的角度考虑，遍历[1, size-1]的，找到这个柱子最左边和最右边最高的柱子，
         * h = Math.min(左柱子高度，右柱子高度) - 本柱子高度，如果h>0, sum+=h
         *
         * 时间复杂度为O(n^2)，空间复杂度为O(1)
         */
        public int trap1(int[] height) {
            int sum = 0;
            for (int i = 0; i < height.length; i++) {
                // 第一个柱子和最后一个柱子不接雨水
                if (i == 0 || i == height.length - 1) continue;

                int rHeight = height[i]; // 记录右边柱子的最高高度
                int lHeight = height[i]; // 记录左边柱子的最高高度
                for (int r = i + 1; r < height.length; r++) {
                    if (height[r] > rHeight) rHeight = height[r];
                }
                for (int l = i - 1; l >= 0; l--) {
                    if (height[l] > lHeight) lHeight = height[l];
                }
                int h = Math.min(lHeight, rHeight) - height[i];
                if (h > 0) sum += h;
            }
            return sum;

        }

        /**
         * 双指针优化
         * 暴力解法里把取左右最高柱子的循环嵌套了，可以拿出来，使用数组存放
         */
        public int trap2(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }

            int sum = 0;
            int len = height.length;
            int[] leftMax = new int[len];
            int[] rightMax = new int[len];

            leftMax[0] = height[0];
            for (int i = 1; i < len; i++) {
                leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            }

            rightMax[len - 1] = height[len - 1];
            for (int i = len - 2; i >= 0; i--) {
                rightMax[i] = Math.max(height[i], rightMax[i + 1]);
            }

            for (int i = 0; i < len; i++) {
                int count = Math.min(leftMax[i], rightMax[i]) - height[i];
                if (count > 0) {
                    sum += count;
                }

            }
            return sum;

        }

        /**
         * 单调栈，从行的方向考虑
         * 从栈头到栈尾单调递增，如果：
         * 1、height[i] < height[st.peek()]  st.push(i)
         * 2、height[i] = height[st.peek()]  st.pop() st.push(i)
         * 3、height[i] > height[st.peek()] 形成凹槽
         */
        public int trap(int[] height) {
            int size = height.length;

            if (size <= 2) return 0;

            Stack<Integer> stack = new Stack<Integer>();
            stack.push(0);

            int sum = 0;
            for (int index = 1; index < size; index++) {
                int stackTop = stack.peek();
                if (height[index] < height[stackTop]) {
                    stack.push(index);
                } else if (height[index] == height[stackTop]) {
                    // 因为相等的相邻墙，左边一个是不可能存放雨水的，所以pop左边的index, push当前的index
                    stack.pop();
                    stack.push(index);
                } else {
                    int heightAtIdx = height[index];
                    while (!stack.isEmpty() && (heightAtIdx > height[stackTop])) {
                        int mid = stack.pop();

                        if (!stack.isEmpty()) {
                            int left = stack.peek();

                            int h = Math.min(height[left], height[index]) - height[mid];
                            int w = index - left - 1;
                            int hold = h * w;
                            if (hold > 0) sum += hold;
                            stackTop = stack.peek();
                        }
                    }
                    stack.push(index);
                }
            }

            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
