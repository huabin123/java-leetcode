package com.huabin.topk;

import com.huabin.common.ListNode;

import java.util.Stack;

/**
 * @Author huabin
 * @DateTime 2023-07-26 09:55
 * @Desc 反转链表
 */
public class Q005_ReverseLinkedList {

    // ------ 解法一：虚指针法 ------
    public static ListNode reverseByPoint(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    // ------ 解法二：栈 ------
    public static ListNode reverseByStack(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode newHead = stack.pop();
        ListNode newCurrent = newHead;
        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            newCurrent.next = node;
            newCurrent = node;
        }
        newCurrent.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode node = listNode.init();
        ListNode node1 = reverseByPoint(node);
        while (node1 != null){
            System.out.println(node1.val);
            node1 = node1.next;
        }

        node = listNode.init();
        ListNode node2 = reverseByStack(node);
        while (node2 != null) {
            System.out.println(node2.val);
            node2 = node2.next;
        }
    }

}
