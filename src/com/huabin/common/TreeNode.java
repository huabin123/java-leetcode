package com.huabin.common;

/**
 * @Author huabin
 * @DateTime 2022-12-20 11:14
 * @Desc 二叉树节点
 */
public class TreeNode {

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }

    public int val;
    public TreeNode left;
    public TreeNode right;

    // 初始化
    public static TreeNode init(){
        /*
         *        5
         *       / \
         *      4   8
         *     /   / \
         *    11  13  4
         *   /  \      \
         *  7    2      1
         */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        return root;
    }

}
