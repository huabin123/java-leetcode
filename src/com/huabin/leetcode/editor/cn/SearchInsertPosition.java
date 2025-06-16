//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 请必须使用时间复杂度为 O(log n) 的算法。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,3,5,6], target = 5
//输出: 2
//
//
// 示例 2:
//
//
//输入: nums = [1,3,5,6], target = 2
//输出: 1
//
//
// 示例 3:
//
//
//输入: nums = [1,3,5,6], target = 7
//输出: 4
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 为 无重复元素 的 升序 排列数组
// -10⁴ <= target <= 10⁴
//
//
// Related Topics 数组 二分查找 👍 2516 👎 0


package com.huabin.leetcode.editor.cn;
public class SearchInsertPosition{
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        int res = solution.searchInsert(new int[]{1, 3, 5, 6}, 0);
        System.out.println(res);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int right = nums.length - 1;
            int left = 0;
            int mid = 0;
            while(left <= right){
                mid = left + (right - left) / 2;
                if(nums[mid] == target){
                    return mid;
                } else if(nums[mid] > target){
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            if(nums[mid] > target){
                return mid;
            }
            return mid + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
