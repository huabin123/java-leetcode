package com.huabin.topk;

import com.huabin.common.ListNode;

/**
 * @Author huabin
 * @DateTime 2023-07-27 15:01
 * @Desc 合并两个有序链表
 */
public class Q009_MergeTwoSortedLists {

    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2){

        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.init();
        ListNode l2 = ListNode.init();
        ListNode newHead = mergeTwoSortedLists(l1, l2);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }

}
