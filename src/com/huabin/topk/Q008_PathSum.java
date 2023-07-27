package com.huabin.topk;

import com.huabin.common.TreeNode;

/**
 * @Author huabin
 * @DateTime 2023-07-27 11:06
 * @Desc 路径总和
 */
public class Q008_PathSum {

    /**
     * 给定一个二叉树和一个目标值，判断是否存在从根节点到叶子节点的路径，使得路径上所有节点值的和等于目标值。
     */
    static class PathSum{
        public boolean hasPathSum(TreeNode root, int sum){
            if (root == null) {
                return false;
            }

            // 如果当前节点是叶子节点，并且其值等于目标值，则返回true
            if (root.left == null && root.right == null && root.val == sum) {
                return true;
            }

            // 递归检查左子树和右子树是否存在路径
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        System.out.println(new PathSum().hasPathSum(root, 18));
    }

}
