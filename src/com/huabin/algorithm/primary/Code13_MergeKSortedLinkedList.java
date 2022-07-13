package com.huabin.algorithm.primary;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author huabin
 * @DateTime 2022-07-13 09:20
 * @Desc 合并K个有序链表
 * 测试链接：https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class Code13_MergeKSortedLinkedList {

    public static class ListNode{
        public int val;
        public ListNode next;
    }

    public static class ListNodeComparator implements Comparator<ListNode>{

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists){
        if (lists == null) {
            return null;
        }

        // 优先级队列 PriorityQueue底层是小根堆结构
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode head = heap.poll();
        ListNode pre = head;

        if (pre.next != null) {
            heap.add(pre.next);
        }

        while (!heap.isEmpty()){
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }

        return head;
    }

}
