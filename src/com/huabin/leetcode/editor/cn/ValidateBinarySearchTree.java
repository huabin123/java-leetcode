//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下：
//
//
// 节点的左子树只包含 小于 当前节点的数。
// 节点的右子树只包含 大于 当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
//
//
// 示例 1：
//
//
//输入：root = [2,1,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
//
//
//
//
// 提示：
//
//
// 树中节点数目范围在[1, 10⁴] 内
// -2³¹ <= Node.val <= 2³¹ - 1
//
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2154 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        TreeNode root = TreeNode.init();
        solution.isValidBST(root);
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
        // 更具二叉搜索树的特性，对二叉搜索树进行中序遍历得到的数组是一个单调递增的有序数组，所以这个题的解法就是
        // 中序遍历，收集元素数组再判断数组是否递增
        List<Integer> list = new ArrayList<>();
        public boolean isValidBST(TreeNode root) {
            this.traversal(root);
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i) >= list.get(i+1)) {
                    return false;
                }
            }
            return true;
        }

        private void traversal(TreeNode node) {
            if (node == null) {
                return;
            }
            traversal(node.left);
            list.add(node.val);
            traversal(node.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
