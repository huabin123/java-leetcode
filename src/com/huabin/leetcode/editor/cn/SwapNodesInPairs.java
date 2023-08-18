//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
//
// Related Topics 递归 链表 👍 1981 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.ListNode;

public class SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
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
        public ListNode swapPairs(ListNode head) {
            // 模拟法
//            // 难点在于不知道要定义哪些变量
//            ListNode dummyNode = new ListNode(-1, head);
//            ListNode cur = dummyNode;
//            ListNode tmp;
//            ListNode firstNode;
//            ListNode secondNode;
//            while (cur.next != null && cur.next.next != null){  // 这里是&&
//                tmp = cur.next.next.next;
//                firstNode = cur.next;
//                secondNode = cur.next.next;
//                cur.next = secondNode;
//                secondNode.next = firstNode;
//                firstNode.next = tmp;
//                cur = firstNode;  // 这里不能是cur = cur.next
//            }
//            return dummyNode.next;

            // 递归
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = head.next;
            ListNode newNode = swapPairs(next.next);
            next.next = head;
            head.next = newNode;
            return next;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
