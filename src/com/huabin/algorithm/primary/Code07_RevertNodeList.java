package com.huabin.algorithm.primary;

/**
 * @Author huabin
 * @DateTime 2022-06-30 09:13
 * @Desc 反转单链表
 */
public class Code07_RevertNodeList {

    public static class Node{
        public int value;
        public Node next;

        public Node(int data){
            value = data;
        }
    }

    public static class DoubleNode{
        private int vaule;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int num){
            vaule = num;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        Node head = reverseLinkedList(n1);
        System.out.println(head.value);
        while (head.next != null) {
            System.out.println(head.next.value);
            head = head.next;
        }
    }

    private static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head!=null){  // 这里不能是head.next 因为head会一直往后移，取的是pre
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static DoubleNode reverseDoubleLinkedList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head!=null){  // 这里不能是head.next 因为head会一直往后移，取的是pre
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

}
