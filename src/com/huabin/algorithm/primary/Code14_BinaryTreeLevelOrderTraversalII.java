package com.huabin.algorithm.primary;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 从底部按层级遍历二叉树
// https://leetcode.com/problems/binary-tree-level-order-traversal-ii
public class Code14_BinaryTreeLevelOrderTraversalII {

    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                curList.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
                ans.add(0, curList);
            }
        }
        return ans;
    }

}
