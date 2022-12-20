//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。
//
//
//
// 示例 1：
//
//
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
//
//
// 示例 2：
//
//
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
//
//
// 示例 3：
//
//
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
//
//
// 示例 4：
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
//
//
//
//
// 提示：
//
//
// -10000 <= Node.val <= 10000
// Node.random 为空（null）或指向链表中的节点。
// 节点数目不超过 1000 。
//
//
//
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-
//pointer/
//
//
//
// Related Topics 哈希表 链表 👍 629 👎 0


package com.huabin.lcof.leetcode.editor.cn;


import com.huabin.common.Node;

public class FuZaLianBiaoDeFuZhiLcof {
    public static void main(String[] args) {
        Solution solution = new FuZaLianBiaoDeFuZhiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    */
    class Solution {
        public Node copyRandomList(Node head) {

            if (head == null) {
                return null;
            }

            Node cur = head;

            // 1. 插入一样的新节点
            while (cur != null) {  // 注意各个while的条件
                Node clone = new Node(cur.val);
                clone.next = cur.next;
                cur.next = clone;
                cur = clone.next;
            }

            // 2.设置复制节点的random指针
            cur = head;
            while (cur != null) {
                Node clone = cur.next;
                if (cur.random != null) {
                    clone.random = cur.random.next;
                }
                cur = clone.next;
            }

            // 3. 拆分链表成原始链表和复制链表
            cur = head;
            Node cloneHead = head.next;
            while (cur.next != null) {
                Node clone = cur.next;
                cur.next = clone.next;
                cur = clone;
            }

            return cloneHead;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
