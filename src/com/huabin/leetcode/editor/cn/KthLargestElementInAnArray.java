//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1668 👎 0

// leetcode-215
package com.huabin.leetcode.editor.cn;
public class KthLargestElementInAnArray{
    public static void main(String[] args) {
        int[] nums = {7, 8, 3, 1, 4, 5, 6, 7};
        Solution solution = new KthLargestElementInAnArray().new Solution();
        solution.findKthLargest(nums, 4);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // // 1、暴力解法
        // public int findKthLargest(int[] nums, int k) {
        //     int len = nums.length;
        //     Arrays.sort(nums);
        //     return nums[len - k];
        // }

        // 2、快排解法
        // 快排思想的核心就是一趟排序至少确认一个元素的顺序，题目是要找第K大的元素，那么就没必要对所有的元素排序，我们要找的下标是nums.length-k,所以只要
        // mid == nums.length-k就可以，如果不是，如果mid>nums.length-k，就从mid左边找，否则则从右边找，这样提升了效率
        public int findKthLargest(int[] nums, int k) {
            // 数组排序
            int left = 0;
            int right = nums.length-1;
            return quickSort(left,right,nums,k);

        }

        private int sort(int[] nums,int left,int right){
            int temp = nums[left];  // 数组第一个元素作为枢纽
            // 这个循环是算法的核心，可以确定left的真实位置下标
            while(left<right){
                while(left<right && nums[right]>=temp) {
                    right--;
                }
                nums[left] = nums[right];
                while(left<right && nums[left]<=temp) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = temp;
            return left;
        }

        private int quickSort(int left, int right, int[] nums, int k){
            int mid = sort(nums, left, right);
            if(mid == nums.length-k) return nums[mid];
            else if (mid > nums.length-k) return quickSort(left, mid-1, nums, k);
            else return quickSort(mid+1,right, nums, k);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}