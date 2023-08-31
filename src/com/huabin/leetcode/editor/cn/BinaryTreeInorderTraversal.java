//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1895 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        TreeNode root = TreeNode.init();
        System.out.println(solution.inorderTraversal(root));
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
//        public List<Integer> inorderTraversal(TreeNode root) {
//            List<Integer> res = new ArrayList<>();
//            traversal(res, root);
//            return res;
//        }
//
//        private void traversal(List<Integer> res, TreeNode node) {
//            if (node == null) {
//                return;
//            }
//            traversal(res, node.left);
//            res.add(node.val);
//            traversal(res, node.right);
//        }

        // 使用栈，迭代实现
        public List<Integer> inorderTraversal(TreeNode root) {
            // 中序遍历的不同在于变量顺序和处理顺序不同，需要先找到最左边的节点
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Stack<TreeNode> stack = new Stack<>();
//            stack.push(root);  // 这里不能直接把root推入，因为是中序，是左中右的顺序
            TreeNode cur = root;  // 这个cur的定义是中序遍历的关键，
            while (!stack.isEmpty() || cur != null) {  // 条件也不同，只要栈不为空或者cur不为null就还有元素要处理，为什么还要cur != null ,因为不是每次都会往stack里push元素
                if (cur != null) {
                    stack.push(cur);  // 栈中保存遍历的元素
                    cur = cur.left;  // 从左子节点开始处理
                } else {
                    cur = stack.pop();  //  如果右子节点为空则从栈中弹出元素
                    res.add(cur.val);  // 弹出的元素就是要处理的元素，加入结果列表中
                    cur = cur.right;  // 指向右子节点
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
