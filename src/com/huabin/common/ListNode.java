package com.huabin.common;

/**
 * @Author huabin
 * @DateTime 2022-12-15 12:09
 * @Desc
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(){

    }

    public ListNode(int data){
        val = data;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode init() {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);
        // 测试环形链表
//        n1.next.next.next.next.next = n1;
        return n1;
    }

}
