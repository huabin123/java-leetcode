package com.huabin.common.tree;

import java.util.List;

/**
 * @Author huabin
 * @DateTime 2023-08-30 11:13
 * @Desc
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
