package com.huabin.algorithm.primary;

/**
 * @Author huabin
 * @DateTime 2022-07-03 10:39
 * @Desc 两数之和 // 测试链接：https://leetcode.com/problems/add-two-numbers/
 */
public class Code11_AddTwoNumbers {

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2){
        // 获取到两个链表的长度，以更长的一个链表上进行加法
        int len1 = getListNodeLen(head1);
        int len2 = getListNodeLen(head2);
        ListNode curL = len1 >= len2 ? head1 : head2;
        ListNode curS = curL == head1 ? head2 : head1;
        ListNode last = null;  // 最后一个进位的位置

        ListNode l = curL;
        ListNode s = curS;  // 这里使用这两个新的变量是为了最后要返回l，直接操作l的话

        int carry = 0;   // 进位
        int curNum = 0;

        while (s!=null){
            curNum = l.val + s.val + carry;
            carry = curNum / 10;
            l.val = curNum % 10;  // l的值需要改变
            last = l;
            l = l.next;
            s = s.next;
        }

        while (l!=null){
            curNum = l.val + carry;
            carry = curNum / 10;
            l.val = curNum % 10;  // l的值需要改变
            last = l;
            l = l.next;
        }
        if (carry!=0){
            last.next = new ListNode(1);
        }
        return curL;
    }

    private static int getListNodeLen(ListNode head){
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] args) {
        Code11_AddTwoNumbers.ListNode listNode = new Code11_AddTwoNumbers.ListNode(2);
        listNode.next = new Code11_AddTwoNumbers.ListNode(4);
        listNode.next.next = new Code11_AddTwoNumbers.ListNode(3);

        Code11_AddTwoNumbers.ListNode listNode1 = new Code11_AddTwoNumbers.ListNode(5);
        listNode1.next = new Code11_AddTwoNumbers.ListNode(6);
        listNode1.next.next = new Code11_AddTwoNumbers.ListNode(4);

        ListNode listNode2 = addTwoNumbers(listNode, listNode1);
        while (listNode2!=null){
            System.out.println(listNode2.val);
            listNode2 = listNode2.next;
        }
    }

}
