//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
//
//
// 示例 2：
//
//
//
//
//输入：root = [2,1,3]
//输出：[2,3,1]
//
//
// 示例 3：
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数目范围在 [0, 100] 内
// -100 <= Node.val <= 100
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1662 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.tree.TreeNode;

public class InvertBinaryTree{
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            // 要先想清楚用怎么遍历，这里最好用前序或者后序，层序也行，
            // 中序不太行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
            if (root == null) {
                return root;
            }
            invertTree(root.left);
            invertTree(root.right);
            swapChildren(root);
            return root;
        }

        private void swapChildren(TreeNode node) {
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
