package com.huabin.topk;

import com.huabin.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Q002_CycleList {

    // ---- 解法一：暴力 时间空间复杂度O(n) -----
    public static boolean hasCycle(ListNode head){
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // ---- 解法二：双指针法 -----
    public static boolean hasCycle2(ListNode head){
        ListNode f = head, s = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode node = listNode.init();
        System.out.println(hasCycle(node));
        System.out.println(hasCycle2(node));
    }

}
