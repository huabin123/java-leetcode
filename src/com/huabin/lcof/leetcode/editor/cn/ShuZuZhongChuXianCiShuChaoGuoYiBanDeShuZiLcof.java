//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//
//
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1:
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2
//
//
//
// 限制：
//
// 1 <= 数组长度 <= 50000
//
//
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
//
//
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 335 👎 0


package com.huabin.lcof.leetcode.editor.cn;

public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 哈希表统计法
     */
//    class Solution {
//        Map<Integer, Integer> countMap = new HashMap<>();
//
//        public int majorityElement(int[] nums) {
//            for (int i = 0; i < nums.length; i++) {
//                if (countMap.containsKey(nums[i])) {
//                    countMap.put(nums[i], countMap.get(nums[i])+1);
//                } else {
//                    countMap.put(nums[i], 1);
//                }
//            }
//            int max = 0;
//            Map.Entry<Integer, Integer> res = null;
//            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
//                if (entry.getValue()>max) {
//                    max = entry.getValue();
//                    res = entry;
//                }
//            }
//            return res.getKey();
//        }
//    }

    /**
     * 摩尔投票法
     */
    class Solution {
        public int majorityElement(int[] nums) {
            int x = 0, votes = 0, count = 0;
            for (int num : nums) {
                if (votes == 0) x = num;
                votes += num == x ? 1 : -1;
            }
            // 验证 x 是否为众数
            for (int num : nums)
                if (num == x) count++;
            return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
