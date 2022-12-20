package com.huabin.common;

/**
 * @Author huabin
 * @DateTime 2022-12-20 17:04
 * @Desc
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
