//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。
//
//
//
// 示例 1:
//
//
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
//
//
// 示例 2:
//
//
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
//
//
//
//
// 提示:
//
//
// 1 <= inorder.length <= 3000
// postorder.length == inorder.length
// -3000 <= inorder[i], postorder[i] <= 3000
// inorder 和 postorder 都由 不同 的值组成
// postorder 中每一个值都在 inorder 中
// inorder 保证是树的中序遍历
// postorder 保证是树的后序遍历
//
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1091 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.tree.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] inorder = {4, 2, 5, 1, 6, 7, 3, 8};
        int[] postorder = {4, 5, 2, 6, 7, 8, 3, 1};
        solution.buildTree(inorder, postorder);
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

        /**
         * 中序遍历序列告诉我们树节点的左右子树的相对顺序，而后序遍历序列告诉我们树的根节点在哪里。
         * 第一步：如果数组大小为零的话，说明是空节点了。
         *
         * 第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。
         *
         * 第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点
         *
         * 第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）
         *
         * 第五步：切割后序数组，切成后序左数组和后序右数组
         *
         * 第六步：递归处理左区间和右区间
         */
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            // 首先检查输入的合法性
            if (inorder == null || postorder == null || inorder.length != postorder.length) {
                return null;
            }

            // 创建一个 HashMap 用于存储中序遍历序列中的值与其对应的索引
            HashMap<Integer, Integer> inorderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }

            // 递归构建二叉树
            return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);
        }

        private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> inorderMap) {
            // 如果 inStart 大于 inEnd，表示子树为空，返回 null
            if (inStart > inEnd) {
                return null;
            }

            // 后序遍历序列的最后一个元素即为当前子树的根节点
            int rootValue = postorder[postEnd];
            TreeNode root = new TreeNode(rootValue);

            // 在中序遍历序列中找到根节点的索引
            int rootIndexInorder = inorderMap.get(rootValue);

            // 计算左子树的节点个数
            int leftSubtreeSize = rootIndexInorder - inStart;

            // 递归构建左子树和右子树
            root.left = buildTreeHelper(inorder, inStart, rootIndexInorder - 1, postorder, postStart, postStart + leftSubtreeSize - 1, inorderMap);
            root.right = buildTreeHelper(inorder, rootIndexInorder + 1, inEnd, postorder, postStart + leftSubtreeSize, postEnd - 1, inorderMap);

            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
