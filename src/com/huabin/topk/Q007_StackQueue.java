package com.huabin.topk;

import java.util.Stack;

/**
 * @Author huabin
 * @DateTime 2023-07-27 10:47
 * @Desc 用栈实现队列
 * 要使用栈来实现队列，可以使用两个栈来模拟队列的先进先出（FIFO）特性。一个栈用于入队操作，另一个栈用于出队操作。当需要进行入队操作时，
 * 将元素压入第一个栈中；当需要进行出队操作时，将第一个栈的元素依次出栈并压入第二个栈，然后从第二个栈中弹出元素，实现队列的出队操作。
 */
public class Q007_StackQueue {

    static class StackQueue<E> {
        private Stack<E> stack1; // 用于入队操作
        private Stack<E> stack2; // 用于出队操作

        public StackQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void enqueue(E element) {
            stack1.push(element);
        }

        public E dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty.");
            }

            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.pop();
        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        public int size() {
            return stack1.size() + stack2.size();
        }

    }

    public static void main(String[] args) {
        StackQueue<Integer> queue = new StackQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeue: " + queue.dequeue()); // Output: 1

        queue.enqueue(4);
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 2
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 3

        queue.enqueue(5);
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 4
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 5
    }

}
