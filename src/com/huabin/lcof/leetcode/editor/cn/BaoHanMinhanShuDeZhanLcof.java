//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
//
//
//
// 示例:
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// 各函数的调用总次数不超过 20000 次
//
//
//
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
//
// Related Topics 栈 设计 👍 415 👎 0


package com.huabin.lcof.leetcode.editor.cn;

import java.util.Stack;

public class BaoHanMinhanShuDeZhanLcof {
//    public static void main(String[] args) {
//        Solution solution = new BaoHanMinhanShuDeZhanLcof().new Solution();
//    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        // 保存数据
        Stack<Integer> dataStack = new Stack<>();

        // 保存最小值
        Stack<Integer> minStack = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            dataStack.push(x);
            if (minStack.isEmpty() || x < minStack.peek()) {
                minStack.push(x);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
