//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明：叶子节点是指没有子节点的节点。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：2
//
//
// 示例 2：
//
//
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
//
//
//
//
// 提示：
//
//
// 树中节点数的范围在 [0, 10⁵] 内
// -1000 <= Node.val <= 1000
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1071 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.tree.TreeNode;

public class MinimumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
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
        public int minDepth(TreeNode root) {
            return this.getDepth(root);
        }

        private int getDepth(TreeNode node) {
            if (node == null) {
                // 左右子节点都为null，说明到了底部
                return 0;
            }
            int leftDepth = getDepth(node.left);
            int rightDepth = getDepth(node.right);

            if (node.left == null && node.right != null) {
                return 1 + rightDepth;
            }
            if (node.left != null && node.right == null) {
                return 1 + leftDepth;
            }
            return 1 + Math.min(leftDepth, rightDepth);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
