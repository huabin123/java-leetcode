//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
//
//
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
// Related Topics 链表 双指针 👍 2639 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode node = solution.removeNthFromEnd(ListNode.init(), 2);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

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
        public ListNode removeNthFromEnd(ListNode head, int n) {

            // 双指针，让fast向末尾移动，当移动到n，slow开始移动，当fast移动到末尾，删除slow即可
//            if (head == null) {
//                return head;
//            }
//            ListNode dummyNode = new ListNode(-1, head);
//            ListNode fast = dummyNode, slow = dummyNode;  // 这里如果fast和slow指向头结点话，不好做删除操作，所以还是只想哑节点
//
//            // fast先走n + 1步，为什么是n+1步，因为slow要指向要删除的前一个节点才能删除n
//            for (int i = 0; i < n + 1; i++) {
//                fast = fast.next;
//            }
//
//            // fast和slow一起走
//            while (fast != null) {
//                fast = fast.next;
//                slow = slow.next;
//            }
//
//            //此时 slowIndex 的位置就是待删除元素的前一个位置。
//            //具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
//            slow.next = slow.next.next;
//
//            return dummyNode.next;

            // 栈
            if (head == null) {
                return head;
            }
            ListNode dummy = new ListNode(0, head);
            Deque<ListNode> stack = new LinkedList<>();
            ListNode cur = dummy;
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }
            // 循环到要删除节点的头一个节点
            for (int i = 0; i < n; i++) {
                stack.pop();
            }
            ListNode pre = stack.peek();
            pre.next = pre.next.next;
            return dummy.next;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
