//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：[[1]]
//
//
// 示例 3：
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 2000] 内
// -1000 <= Node.val <= 1000
//
//
// Related Topics 树 广度优先搜索 二叉树 👍 1781 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        TreeNode root = TreeNode.init();
        System.out.println(solution.levelOrder(root));
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
        public List<List<Integer>> resList = new ArrayList<List<Integer>>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            checkFun01(root,0);  // 确定递归方法的参数，一个node和深度
//            checkFun02(root);

            return resList;
        }

        //BFS--迭代方式--借助队列
        public void checkFun02(TreeNode node) {
            if (node == null) return;
            Queue<TreeNode> que = new LinkedList<TreeNode>();
            que.offer(node);  // 传入头结点，作为遍历的起点

            while (!que.isEmpty()) {  // 外层的循环，在队列为空之前一直运行，遍历每一层
                List<Integer> itemList = new ArrayList<Integer>();  // 保存当前一层的结果
                int len = que.size();  // 这里是内层的关键，决定了有几个节点要处理

                while (len > 0) {  // 内层循环，这里的len是固定的，有几个就处理几次
                    TreeNode tmpNode = que.poll();  // 从队头取出要处理的节点
                    itemList.add(tmpNode.val);

                    if (tmpNode.left != null) // 不要忘了这个判断，不然循环出不来
                        que.offer(tmpNode.left);  // 加入左节点待下一次遍历
                    if (tmpNode.right != null) que.offer(tmpNode.right);  // 加入右节点待下一次遍历
                    len--;
                }

                resList.add(itemList);
            }

        }

        //DFS--递归方式
        public void checkFun01(TreeNode node, Integer deep) {
            if (node == null) return;  // 递归终止条件
            deep++;  // 深度加一，表示进入下一层

            if (resList.size() < deep) {
                // 这个判断是递归法的关键，当层级增加时，list的Item也增加，利用list的索引值进行层级界定
                // resList.size() < deep说明进入了新的一层
                List<Integer> item = new ArrayList<Integer>();
                resList.add(item);
            }
            resList.get(deep - 1).add(node.val);  // 将当前节点的值添加到 resList 中对应深度的列表中，注意索引要用deep-1

            checkFun01(node.left, deep);
            checkFun01(node.right, deep);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
