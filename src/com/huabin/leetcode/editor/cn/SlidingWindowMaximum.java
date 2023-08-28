//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。
//
// 返回 滑动窗口中的最大值 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
// 示例 2：
//
//
//输入：nums = [1], k = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
// 1 <= k <= nums.length
//
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2456 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7, 8, 9, 10};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
//        public int[] maxSlidingWindow(int[] nums, int k) {
//            if (nums == null || nums.length == 0) {
//                return new int[0];
//            }
//
//            int n = nums.length;
//            int[] result = new int[n - k + 1];
//            int resultIdx = 0;
//
//            Deque<Integer> deque = new ArrayDeque<>(); // Store indices of elements in decreasing order
//
//            for (int i = 0; i < n; i++) {
//                // Remove elements outside of the current window
//                while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
//                    deque.pollFirst();
//                }
//
//                // Remove smaller elements as they are no longer candidates for maximum
//                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
//                    deque.pollLast();
//                }
//
//                // Add current element's index to the deque
//                deque.offerLast(i);
//
//                // The maximum element is at the front of the deque
//                if (i >= k - 1) {
//                    result[resultIdx++] = nums[deque.peekFirst()];
//                }
//            }
//
//            return result;
//        }
//
//    }


    //解法一
    //自定义数组
//    class MyQueue {
//        Deque<Integer> deque = new LinkedList<>();
//
//        //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
//        //同时判断队列当前是否为空
//        void poll(int val) {
//            if (!deque.isEmpty() && val == deque.peek()) {
//                deque.poll();
//            }
//        }
//
//        //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
//        //保证队列元素单调递减
//        //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
//        void add(int val) {
//            while (!deque.isEmpty() && val > deque.getLast()) {
//                deque.removeLast();
//            }
//            deque.add(val);
//        }
//
//        //队列队顶元素始终为最大值
//        int peek() {
//            return deque.peek();
//        }
//    }
//
//    class Solution {
//        public int[] maxSlidingWindow(int[] nums, int k) {
//            if (nums.length == 1) {
//                return nums;
//            }
//            int len = nums.length - k + 1;
//            //存放结果元素的数组
//            int[] res = new int[len];
//            int num = 0;
//            //自定义队列
//            MyQueue myQueue = new MyQueue();
//            //先将前k的元素放入队列
//            for (int i = 0; i < k; i++) {
//                myQueue.add(nums[i]);
//            }
//            res[num++] = myQueue.peek();
//            for (int i = k; i < nums.length; i++) {
//                //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
//                myQueue.poll(nums[i - k]);
//                //滑动窗口加入最后面的元素
//                myQueue.add(nums[i]);
//                //记录对应的最大值
//                res[num++] = myQueue.peek();
//            }
//            return res;
//        }
//    }

    // 双向队列
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length < 2) return nums;
            // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
            LinkedList<Integer> queue = new LinkedList();
            // 结果数组
            int[] result = new int[nums.length - k + 1];
            // 遍历nums数组
            for (int i = 0; i < nums.length; i++) {
                // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }
                // 添加当前值对应的数组下标
                queue.addLast(i);
                // 判断当前队列中队首的值是否有效
                if (queue.peek() <= i - k) {
                    queue.poll();
                }
                // 当窗口长度为k时 保存当前窗口中最大值
                if (i + 1 >= k) {
                    result[i + 1 - k] = nums[queue.peek()];
                }
            }
            return result;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
