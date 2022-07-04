package com.huabin.algorithm.primary;

/**
 * @Author huabin
 * @DateTime 2022-07-02 09:38
 * @Desc 按照k个数给数组分组，不满k个不分组，每个k个数的小组内倒序排列 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class Code10_ReverseNodesInKGroups {

    //这段不拷贝到leetcode
    public static class ListNode{
        int value;
        ListNode next;
        ListNode(int val){
            this.value = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(5);
        listNode.next.next.next = new ListNode(7);
        reverseKGroup(listNode, 3);
    }

    /**
     * @param head
     * @param k
     * @return 处理后的头结点
     */
    public static ListNode reverseKGroup(ListNode head, int k){
        ListNode start = head;
        ListNode end = findKNodeInGroup(start, k);
        if (end == null) {
            return head;
        }
        // 第一组凑齐了
        head = end;
        reverse(start, end);  // 第一组处理完成
        ListNode lastEnd = start;
        while (lastEnd.next != null){
            start = lastEnd.next;
            end = findKNodeInGroup(start, k);
            if (end == null) {  // 为null说明这一组凑不满k个数了，直接返回即可
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    private static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode cur = start;
        ListNode pre = null;
        ListNode next = null;
        while (cur!=end){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    private static ListNode findKNodeInGroup(ListNode start, int k) {
        while (--k!=0 && start != null){
            start = start.next;
        }
        return start;
    }

}
