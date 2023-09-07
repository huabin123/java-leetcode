//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。
//
// 假定 BST 满足如下定义：
//
//
// 结点左子树中所含节点的值 小于等于 当前节点的值
// 结点右子树中所含节点的值 大于等于 当前节点的值
// 左子树和右子树都是二叉搜索树
//
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,2]
//输出：[2]
//
//
// 示例 2：
//
//
//输入：root = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [1, 10⁴] 内
// -10⁵ <= Node.val <= 10⁵
//
//
//
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 682 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.tree.TreeNode;

import java.util.ArrayList;

public class FindModeInBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
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
        // 众数：出现频率最高的数
        ArrayList<Integer> list = new ArrayList<>();
        int count;
        int maxCount;
        TreeNode pre;
        public int[] findMode(TreeNode root) {
            traversal(root);
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }

        public void traversal(TreeNode root) {
            if (root == null) {
                return;
            }
            traversal(root.left);
            int rootValue = root.val;

            // 计数
            if (pre == null || rootValue!= pre.val) {
                count = 1;
            } else {
                count++;
            }

            if (count > maxCount) {
                list.clear();
                list.add(rootValue);
                maxCount = count;
            } else if (count == maxCount) {
                list.add(rootValue);
            }
            pre = root;

            traversal(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
