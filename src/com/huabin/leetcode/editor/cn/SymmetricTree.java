//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,2,3,4,4,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,null,3,null,3]
//输出：false
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [1, 1000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2522 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.tree.TreeNode;

public class SymmetricTree{
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            // root的左右两边两棵树，左树和右树，左树前序遍历，右树后序遍历
            if (root == null) {
                return true;
            }

            // 确定递归的出入参，出参：boolean，入参：左右子树
            return this.compare(root.left, root.right);
        }

        private boolean compare(TreeNode left, TreeNode right) {
            // 确定终止条件
            if (left == null && right != null) {
                return false;
            } else if (left != null && right == null) {
                return false;
            } else if (left == null && right == null) {
                return true;
            } else if (left.val != right.val) {
                return false;
            }

            // 此时就是左右节点都不为空，且值相等的情况
            boolean outside = compare(left.left, right.right);
            boolean inside = compare(left.right, right.left);
            return outside && inside;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
