//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//
// 假设二叉树中至少有一个节点。
//
//
//
// 示例 1:
//
//
//
//
//输入: root = [2,1,3]
//输出: 1
//
//
// 示例 2:
//
//
//
//
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [1,10⁴]
//
// -2³¹ <= Node.val <= 2³¹ - 1
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 518 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.tree.TreeNode;

import java.util.*;

public class FindBottomLeftTreeValue{
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
        TreeNode init = TreeNode.init();
        System.out.println(solution.findBottomLeftValue(init));
        System.out.println(solution.findBottomLeftValue02(init));
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
        public int findBottomLeftValue(TreeNode root) {
            // 思路：用迭代法做层序遍历，取最后一层的第一个值
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
//            List<List<Integer>> resList = new ArrayList<>();  不用每一个都记下来，只记最后一个就行了
            int res = 0;
            while (!queue.isEmpty()) {
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    TreeNode node = queue.poll();
                    if (i == 0) {
                        res = node.val;
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return res;
        }

        // 递归，最底层最左边的节点不一定是左节点，只要优先遍历左节点就可以，找到深度最大的叶子节点
        int maxDepth = -1;  // 已访问过的最大深度
        int res = 0;
        public int findBottomLeftValue02(TreeNode root) {
            this.findLeftValue(root, 0);
            return res;
        }

        private void findLeftValue(TreeNode root, int depth) {
            if (root.left == null && root.right == null) {
                if (depth > maxDepth) {
                    maxDepth = depth;
                    res = root.val;
                }
                return;
            }
            if (root.left != null) {
                depth++;
                findLeftValue(root.left, depth);
                depth--;
            }
            if (root.right != null) {
                depth++;
                findLeftValue(root.right, depth);
                depth--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
