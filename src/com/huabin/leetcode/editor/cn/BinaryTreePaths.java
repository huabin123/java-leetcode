//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。
//
// 示例 1：
//
//
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：["1"]
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [1, 100] 内
// -100 <= Node.val <= 100
//
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 1018 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        TreeNode root = TreeNode.init();
        System.out.println(solution.binaryTreePaths(root));
        System.out.println(solution.binaryTreePaths02(root));
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
         * 递归法
         */
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();  // 存最终的结果
            if (root == null) {
                return res;
            }
            List<Integer> paths = new ArrayList<>();  // 作为结果中的路径
            traversal(root, paths, res);
            return res;
        }

        private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
            paths.add(root.val);// 前序遍历，中
            // 遇到叶子结点
            if (root.left == null && root.right == null) {
                // 输出
                StringBuilder sb = new StringBuilder();// StringBuilder用来拼接字符串，速度更快
                for (int i = 0; i < paths.size() - 1; i++) {
                    sb.append(paths.get(i)).append("->");
                }
                sb.append(paths.get(paths.size() - 1));// 记录最后一个节点
                res.add(sb.toString());// 收集一个路径
                return;
            }
            // 递归和回溯是同时进行，所以要放在同一个花括号里
            if (root.left != null) { // 左
                traversal(root.left, paths, res);
                paths.remove(paths.size() - 1);// 回溯
            }
            if (root.right != null) { // 右
                traversal(root.right, paths, res);
                paths.remove(paths.size() - 1);// 回溯
            }
        }


        // 自己写一遍
        private List<String> binaryTreePaths02(TreeNode root){
            List<String> res = new ArrayList<>();
            List<Integer> paths = new ArrayList<>();
            this.traversal02(root, paths, res);
            return res;
        }

        private void traversal02(TreeNode root, List<Integer> paths, List<String> res) {
            paths.add(root.val);  // 中，不要忘了这一步
            if (root.left == null && root.right == null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < paths.size() - 1; i++) {
                    sb.append(paths.get(i)).append("->");
                }
                sb.append(paths.get(paths.size() - 1));
                res.add(sb.toString());
                return;
            }
            if (root.left != null) {
                traversal02(root.left, paths, res);
                paths.remove(paths.size() - 1);
            }
            if (root.right != null) {
                traversal02(root.right, paths, res);
                paths.remove(paths.size() - 1);
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
