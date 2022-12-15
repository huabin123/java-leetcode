//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
// 示例 1：
//
// 输入：head = [1,3,2]
//输出：[2,3,1]
//
//
//
// 限制：
//
// 0 <= 链表长度 <= 10000
// Related Topics 栈 递归 链表 双指针 👍 356 👎 0


package com.huabin.lcof.leetcode.editor.cn;

import java.util.*;

public class CongWeiDaoTouDaYinLianBiaoLcof {

    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        int[] ints = solution.reversePrint(new ListNode().init());
        System.out.println(Arrays.toString(ints));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1 -> 2 -> 3
         * listNode   1 -> 2 -> 3
         * tmp   cur
         * listNode <- 1 <- 2 <- 3
         * @param head
         * @return
         */
        public int[] reversePrint(ListNode head) {
            // 1 -> 2 -> 3
            ListNode listNode = null;
            int size = 0;
            while (head != null) {
                size++;
                ListNode tmp = head.next;
                head.next = listNode;
                listNode = head;
                head = tmp;
            }

            int[] ints = new int[size];
            int index = 0;
            while (listNode != null) {
                System.out.println(listNode.val);
                ints[index] =listNode.val;
                listNode = listNode.next;
                index++;
            }

            return ints;
        }
    }

//    class Solution {
//        public int[] reversePrint(ListNode head) {
//            ArrayList<Integer> list = new ArrayList<>();
//            while (head != null) {
//                list.add(head.val);
//                head = head.next;
//            }
//            Collections.reverse(list);
//            int[] ints = new int[list.size()];
//            for (int i = 0; i < list.size(); i++) {
//                ints[i] = list.get(i);
//            }
//            return ints;
//        }
//    }

//    class Solution {
//        public int[] reversePrint(ListNode head) {
//
//            Stack<Integer> stack = new Stack<Integer>();
//            while (head != null) {
//                stack.add(Integer.valueOf(head.val));
//                head = head.next;
//            }
//            int[] ints = new int[stack.size()];
//
//            int size = stack.size();
//            for (int i = 0; i < size; i++) {
//                ints[i] = stack.pop();
//            }
//            return ints;
//        }
//    }
    //leetcode submit region end(Prohibit modification and deletion)

}
