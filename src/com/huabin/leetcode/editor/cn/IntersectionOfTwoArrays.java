//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//
//
// 示例 2：
//
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000
//
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 811 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.HashSet;

public class IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 暴力法
//        public int[] intersection(int[] nums1, int[] nums2) {
//            HashSet<Integer> set = new HashSet<>();
//            for (int i = 0; i < nums1.length; i++) {
//                for (int j = 0; j < nums2.length; j++) {
//                    if (nums1[i] == nums2[j]) {
//                        set.add(nums1[i]);
//                    }
//                }
//            }
//            int[] res = new int[set.size()];
//            int index = 0;
//            for (Integer val : set) {
//                res[index++] = val;
//            }
//            return res;
//        }

        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set = new HashSet<>();
            HashSet<Integer> resSet = new HashSet<>();
            for (int i = 0; i < nums1.length; i++) {
                set.add(nums1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                if (set.contains(nums2[i])) {
                    resSet.add(nums2[i]);
                }
            }

            // 方法一
//            return resSet.stream().mapToInt(x -> x).toArray();

            // 方法二
            int[] res = new int[resSet.size()];
            int index = 0;
            for (Integer val : resSet) {
                res[index++] = val;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
