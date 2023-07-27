package com.huabin.topk;

import com.huabin.common.ListNode;

/**
 * @Author huabin
 * @DateTime 2023-07-27 10:04
 * @Desc 删除链表的倒数第 N 个结点
 */
public class Q006_RemoveNthNodeFromEnd {

    private static ListNode removeNthNodeFromEnd(int n, ListNode head){

        if (head == null) {
            return null;
        }

        // 创建虚拟头节点，以便处理删除头节点的情况
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        // 将快指针向前移动 n+1 步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 同时移动快慢指针，直到快指针到达链表末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 此时慢指针指向要删除节点的前一个节点
        slow.next = slow.next.next;

        return dummyHead.next;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode node = listNode.init();
        ListNode node1 = removeNthNodeFromEnd(2, node);
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

}
