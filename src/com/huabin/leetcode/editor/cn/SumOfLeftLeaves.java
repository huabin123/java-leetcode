//给定二叉树的根节点 root ，返回所有左叶子之和。
//
//
//
// 示例 1：
//
//
//
//
//输入: root = [3,9,20,null,null,15,7]
//输出: 24
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// 示例 2:
//
//
//输入: root = [1]
//输出: 0
//
//
//
//
// 提示:
//
//
// 节点数在 [1, 1000] 范围内
// -1000 <= Node.val <= 1000
//
//
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 646 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.tree.TreeNode;

public class SumOfLeftLeaves{
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
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
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftSum = sumOfLeftLeaves(root.left);
            int rightSum = sumOfLeftLeaves(root.right);

            int midValue = 0;
            if (root.left != null && root.left.left == null && root.left.right == null) {
                // 这一步是关键，左叶子需要满足两个条件，一：自己是叶子节点，二：自己是父节点的左孩子。所以只能在左叶子的父节点做判断
                midValue = root.left.val;
            }
            return midValue + leftSum + rightSum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
