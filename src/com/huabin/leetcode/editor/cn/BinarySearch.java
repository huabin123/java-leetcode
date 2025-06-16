//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。
//
//
//示例 1:
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
//
//
// 示例 2:
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
//
//
//
//
// 提示：
//
//
// 你可以假设 nums 中的所有元素是不重复的。
// n 将在 [1, 10000]之间。
// nums 的每个元素都将在 [-9999, 9999]之间。
//
// Related Topics 数组 二分查找 👍 939 👎 0


package com.huabin.leetcode.editor.cn;
public class BinarySearch{
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        int search = solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 88);
        System.out.println(search);
    }

//    //leetcode submit region begin(Prohibit modification and deletion)
    // 20250608
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                System.out.println("mid:" + mid);
                System.out.println("left:" + left);
                System.out.println("right:" + right);
                System.out.println("================");
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }

//    class Solution {
//        /**
//         * 存在返回下标，不存在返回-1
//         * @param nums
//         * @param target
//         * @return
//         */
//        public int search(int[] nums, int target) {
//            // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
//            if (target < nums[0] || target > nums[nums.length - 1]) {
//                return -1;
//            }
//            int left = 0, right = nums.length - 1;
//            while (left <= right) {
//                int mid = left + ((right - left) >> 1);
//                if (nums[mid] == target)
//                    return mid;
//                else if (nums[mid] < target)
//                    left = mid + 1;
//                else if (nums[mid] > target)
//                    right = mid - 1;
//            }
//            return -1;
//        }
//    }
//    //leetcode submit region end(Prohibit modification and deletion)


//    class Solution {
//        public int search(int[] nums, int target) {
//            int len = nums.length;
//            if (len == 0) {
//                return -1;
//            }
//            if (len == 1) {
//                if (nums[0] == target) return 0;
//                else return -1;
//            }
//            int l = 0;
//            int r = len - 1;
//            int mid;
//            while (r >= l) {
//                mid = getMid(l, r);
//                if (nums[mid] == target) return mid;
//                else if (nums[mid] > target) r = mid - 1;
//                else l = mid + 1;
//            }
//            return -1;
//        }
//
//        private int getMid(int l, int r) {
//            return (r + l) / 2;
//        }
//    }

}
