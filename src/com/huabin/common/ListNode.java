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

    public ListNode init() {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        return n1;
    }

}
