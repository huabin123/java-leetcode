//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：[2,1]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000
//
//
//
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
//
// Related Topics 递归 链表 👍 3291 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.ListNode;

import java.util.Stack;

public class ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
//        public ListNode reverseList(ListNode head) {
//            ListNode cur = head;
//            ListNode pre = null;
//            ListNode tmp = null;
//            while (cur != null) {
//                tmp = cur.next;  // 必须要有一个临时节点保存下一个节点
//                cur.next = pre;
//                pre = cur;
//                cur = tmp;  // 如果没有保存tmp，这里直接用cur = cur.next,那么cur就一直异地他不
//            }
//            return pre;
//        }

        // 错误的栈实现
        public ListNode reverseListByStackError(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            while (head != null) {
                stack.push(head);
                head = head.next;
            }
            head = stack.pop();
            ListNode cur = head;
            while (!stack.isEmpty()) {
                head.next = stack.pop();
                head = head.next;  // 这样写会自己等于自己，其实只要调了上面这一步head.next，下面就不能再用head.next给别人赋值
            }
            cur.next = null;
            return cur;
        }

        // 正确的栈实现
        public ListNode reverseListByStackRight(ListNode head) {
            if (head == null) {
                return head;
            }
            Stack<ListNode> stack = new Stack<>();
            ListNode cur = head;
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }
            ListNode newHead = stack.pop();
            cur = newHead;
            while (!stack.isEmpty()) {
                ListNode newNext = stack.pop();  // 这里需要一个临时变量接，让cur变成下一个值
                cur.next = newNext;
                cur = newNext;
            }
            cur.next = null;  // 这里不设置的话会报Error - Found cycle in the ListNode
            return newHead;
        }

        // 递归实现
//        public ListNode reverseListByRecursive(ListNode head) {
        public ListNode reverseList(ListNode head) {
            return reverse(null, head);
        }

        private ListNode reverse(ListNode pre, ListNode cur) {
            if (cur == null) {  // 这里要是cur，不能是pre
                return pre;
            }
            ListNode tmp = cur.next;
            cur.next = pre;
            return reverse(cur, tmp);
        }

    }


    //leetcode submit region end(Prohibit modification and deletion)

}
