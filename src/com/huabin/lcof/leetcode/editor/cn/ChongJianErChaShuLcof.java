////输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
////
//// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
////
////
////
//// 示例 1:
////
////
////Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
////Output: [3,9,20,null,null,15,7]
////
////
//// 示例 2:
////
////
////Input: preorder = [-1], inorder = [-1]
////Output: [-1]
////
////
////
////
//// 限制：
////
//// 0 <= 节点个数 <= 5000
////
////
////
//// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-
//from-
////preorder-and-inorder-traversal/
//// Related Topics 树 数组 哈希表 分治 二叉树 👍 942 👎 0
//


package com.huabin.lcof.leetcode.editor.cn;

import java.util.*;

public class ChongJianErChaShuLcof {

    public static void main(String[] args) {
        Solution solution = new ChongJianErChaShuLcof().new Solution();
        int[] preorder = {1,2,4,7,2,5,6,8};
        int[] inorder = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 利用map便于直接根据先序遍历的值定位到中序遍历的索引
     */
    private static Map<Integer, Integer> map = new HashMap<>();

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return reConstructBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode reConstructBinaryTree(int[] pre, int preStartIndex, int preEndIndex,
                                               int[] in, int inStartIndex, int inEndIndex) {
            if (preStartIndex > preEndIndex) {
                return null;
            }
            int root = pre[preStartIndex];
            TreeNode rootNode = new TreeNode(root);
            Integer rootIndexOfIn = map.get(root);
            rootNode.left = reConstructBinaryTree(pre,
                    preStartIndex + 1,
                    preStartIndex + rootIndexOfIn - inStartIndex,
                    in,
                    inStartIndex,
                    rootIndexOfIn - 1);
            rootNode.right = reConstructBinaryTree(pre,
                    preStartIndex + rootIndexOfIn - inStartIndex + 1,
                    preEndIndex,
                    in,
                    rootIndexOfIn + 1,
                    inEndIndex);
            return rootNode;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
