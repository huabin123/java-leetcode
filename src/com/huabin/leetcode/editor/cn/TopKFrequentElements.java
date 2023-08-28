//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
//
// 示例 2:
//
//
//输入: nums = [1], k = 1
//输出: [1]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// k 的取值范围是 [1, 数组中不相同的元素的个数]
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
//
//
//
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1661 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.*;

public class TopKFrequentElements{
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    // 哈希
    class Solution {
        // 哈希
//        public int[] topKFrequent(int[] nums, int k) {
//            HashMap<Integer, Integer> numCountMap = new HashMap<>();
//            for (int num : nums) {
//                numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
//            }
//            ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(numCountMap.entrySet());
//            Collections.sort(entries, Map.Entry.comparingByValue());
//            Collections.reverse(entries);
//            int[] res = new int[k];
//            for (int i = 0; i < k; i++) {
//                res[i] = entries.get(i).getKey();
//            }
//            return res;
//        }

        //解法1：基于大顶堆实现
        public int[] topKFrequent(int[] nums, int k) {

            Map<Integer, Integer> map = new HashMap<>();//key为数组元素值,val为对应出现次数
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
            //出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
            // 这行代码创建了一个优先队列（PriorityQueue），其中存储了整数数组。这个优先队列将根据数组的第二个元素（索引为1的元素）的值来进行优先级比较，并且按照降序排列，也就是说，具有更大第二个元素值的数组会被认为是更高优先级。
            PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {//大顶堆需要对所有元素进行排序
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {//依次从队头弹出k个,就是出现频率前k高的元素
                ans[i] = pq.poll()[0];
            }
            return ans;
        }
    }



    //
    //leetcode submit region end(Prohibit modification and deletion)

}
