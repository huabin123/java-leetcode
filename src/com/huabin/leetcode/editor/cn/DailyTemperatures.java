//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
//
//
// 示例 1:
//
//
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
//
//
// 示例 2:
//
//
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
//
//
// 示例 3:
//
//
//输入: temperatures = [30,60,90]
//输出: [1,1,0]
//
//
//
// 提示：
//
//
// 1 <= temperatures.length <= 10⁵
// 30 <= temperatures[i] <= 100
//
//
// Related Topics 栈 数组 单调栈 👍 1615 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures{
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {

            int lens = temperatures.length;
            int[] res = new int[lens];  // 在这里res里的元素全都是默认的0，所以后面为零的就已经在这里处理了

            /**
             两种情况：
             1、如果当前遍历的元素t[i] 大于栈顶元素t[stack.peek()]，表示栈顶元素的右边的更大的元素就是当前遍历的元素，
                所以弹出 栈顶元素，并记录，然后，如果栈不为空且还满足当前遍历元素大于栈顶，则还是弹出栈顶元素，记录结果
                最后不满足条件了，把t[i]推入栈
             2、如果当前遍历的元素t[i] 小于等于栈顶元素t[stack.peek()]，则直接入栈

             注意，单调栈里 加入的元素是 下标。
             */
            Deque<Integer> stack = new LinkedList<>();
            stack.push(0);
            for (int i = 1; i < lens; i++) {
                if (temperatures[i] <= temperatures[stack.peek()]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                        res[stack.peek()] = i - stack.peek();
                        stack.pop();
                    }
                    stack.push(i);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
