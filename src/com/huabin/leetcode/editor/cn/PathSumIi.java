//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//
// 叶子节点 是指没有子节点的节点。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
//
//
// 示例 2：
//
//
//输入：root = [1,2,3], targetSum = 5
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1,2], targetSum = 0
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点总数在范围 [0, 5000] 内
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000
//
//
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 1031 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumIi{
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
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

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return res;
            }
            path.add(root.val);
            traversal(root, targetSum - root.val);
            return res;
        }

        private void traversal(TreeNode node, int sum) {
            if (node.left == null && node.right == null && sum == 0) {
//                res.add(path);  // 这里这么写会导致结果里都是同一条路径
                res.add(new ArrayList<>(path));
                return;
            }
            if (node.left == null && node.right == null){
                return;
            }

            if (node.left != null) {
                path.add(node.left.val);
                sum -= node.left.val;
                traversal(node.left, sum);
                sum += node.left.val;
                path.remove(path.size() - 1);
            }
            if (node.right != null) {
                path.add(node.right.val);
                sum -= node.right.val;
                traversal(node.right, sum);
                sum += node.right.val;
                path.remove(path.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
