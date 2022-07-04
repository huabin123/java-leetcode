package com.huabin.algorithm.primary;

/**
 * @Author huabin
 * @DateTime 2022-07-01 12:25
 * @Desc 单向链表转队列和栈
 */
public class Code08_LinkedListToQueueAndStack {

    public static class Node<V>{
        public V value;
        public Node<V> next;

        public Node(V v){
            value = v;
            next = null;
        }
    }

    public static class MyQueue<V>{
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public int size(){
            return this.size;
        }

        /**
         * 添加元素
         * @param value 添加的元素
         */
        public void offer(V value){
            Node<V> cur = new Node<V>(value);
            if (tail == null) {
                // 说明是第一个元素
                head = cur;
                tail = cur;
            }else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        /**
         * 弹出元素，从前往后弹出
         * @return
         */
        public V poll(){
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }else {
                tail = null;
            }
            return ans;
        }

    }

    public static class MyStack<V>{
        private Node<V> head;
        private int size;

        public MyStack(){
            head = null;
            size = 0;
        }

        public void push(V value){
            Node<V> cur = new Node<>(value);
            if (head == null) {
                head = cur;
            }else {
                cur.next = head;  // 新来的节点指向旧节点
                head = cur;  // head指向新节点
            }
            size++;
        }

        public V pop(){
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            return ans;
        }
    }

}
