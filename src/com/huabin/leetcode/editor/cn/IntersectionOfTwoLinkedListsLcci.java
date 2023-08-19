//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
//
// 图示两个链表在节点 c1 开始相交：
//
//
//
// 题目数据 保证 整个链式结构中不存在环。
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。
//
//
//
// 示例 1：
//
//
//
//
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2,
//skipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//
//
// 示例 2：
//
//
//
//
//输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
//
// 示例 3：
//
//
//
//
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
//
//
//
//
// 提示：
//
//
// listA 中节点数目为 m
// listB 中节点数目为 n
// 0 <= m, n <= 3 * 10⁴
// 1 <= Node.val <= 10⁵
// 0 <= skipA <= m
// 0 <= skipB <= n
// 如果 listA 和 listB 没有交点，intersectVal 为 0
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
//
//
//
//
// 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
//
// Related Topics 哈希表 链表 双指针 👍 382 👎 0


package com.huabin.leetcode.editor.cn;

import com.huabin.common.ListNode;

public class IntersectionOfTwoLinkedListsLcci{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedListsLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curA = headA;
            ListNode curB = headB;
            // 计算A长度
            int lenA = 0;
            while (curA != null) {
                lenA++;
                curA = curA.next;
            }
            // 计算B长度
            int lenB = 0;
            while (curB != null) {
                lenB++;
                curB = curB.next;
            }
            // 复位
            curA = headA;
            curB = headB;

            // 保证A为较长的链表，基于长链表操作
            if (lenB > lenA) {
                // 交换
                ListNode tmpNode = curA;
                curA = curB;
                curB = tmpNode;

                int tmpLen = lenA;
                lenA = lenB;
                lenB = tmpLen;
            }

            // A为较长链表，往前走和B对齐
            // 算出A和B的gap
            int gap = lenA - lenB;
            while (gap-- > 0) {
                curA = curA.next;
            }

            // 一起往下走，看有没有相等的节点，有则返回，没有则返回null
            while (curA != null) {
                if (curA == curB) {  // 这里不需要使用curA.next == curB.next，否则[1] [1]的情况过不了
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
