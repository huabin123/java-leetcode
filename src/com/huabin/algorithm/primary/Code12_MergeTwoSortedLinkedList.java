package com.huabin.algorithm.primary;

/**
 * @Author huabin
 * @DateTime 2022-07-04 13:18
 * @Desc 合并两个有序链表 测试链接：https://leetcode.com/problems/merge-two-sorted-lists
 */
public class Code12_MergeTwoSortedLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode mergeTwoSortedLinkedList(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null){
            return head1 == null ? head2 : head1;
        }

        ListNode head = head1.val <= head2.val ? head1 : head2;

        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;

        while (cur1!=null && cur2!=null){
            if (cur1.val<=cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            }else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;

        return head;
    }

}
