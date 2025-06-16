//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
//
//
//
// 说明:
//
// 为什么返回数值是整数，但输出的答案是数组呢?
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
//
// 你可以想象内部操作如下:
//
//
//// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
//int len = removeElement(nums, val);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
//
//
//
//
// 示例 1：
//
//
//输入：nums = [3,2,2,3], val = 3
//输出：2, nums = [2,2]
//解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而
//nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
//
//
// 示例 2：
//
//
//输入：nums = [0,1,2,2,3,0,4,2], val = 2
//输出：5, nums = [0,1,4,0,3]
//解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面
//的元素。
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 100
// 0 <= nums[i] <= 50
// 0 <= val <= 100
//
// Related Topics 数组 双指针 👍 1435 👎 0


package com.huabin.leetcode.editor.cn;

/**
 * 027 移除元素
 */
public class RemoveElement{
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        System.out.println(solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    // 双指针解法
    class Solution {
        /**
         * 注意题目说了不需要考虑数组中超出新长度后面的元素，所以只要保证数组的前面是需要的元素就行，因此遍历数组，只要num != value
         * 就nums[ans] = num，如果等于就跳过了。但是这个属于数学解法。
         * 好吧，其实这就是双指针解法，ans就是慢指针。。。。。
         * @param nums
         * @param val
         * @return
         */
        public int removeElement(int[] nums, int val) {
//            // 这里先定义出结果，不使用fori循环
//            int ans = 0;
//            for(int num : nums){
//                if(num != val){  // 这里是num，不是nums[ans]
//                    nums[ans] = num;
//                    ans++;
//                }
//            }
//            return ans;

//            // 改成这样就是很明显的双指针了，同向双指针
//            int slowIndex = 0;
//            for(int fastIndex = 0; fastIndex<nums.length; fastIndex++){
//                if(nums[fastIndex] != val){
//                    nums[slowIndex++] = nums[fastIndex];
//                }
//            }
//            return slowIndex;

            // 试一下相向双指针，这样可以移动最少的元素
            // 做不出来  0, 1, 2, 2, 3, 0, 4, 2 val = 2
            int leftIndex = 0;
            int rightIndex = nums.length - 1;
            while (leftIndex <= rightIndex) {
                // 找左边等于val的元素
                while (leftIndex <= rightIndex && nums[leftIndex] != val) {
                    ++leftIndex;
                }
                // 找右边不等于val的元素
                while (leftIndex <= rightIndex && nums[rightIndex] == val) {
                    --rightIndex;
                }
                // 将右边不等于val的元素覆盖左边等于val的元素
                if (leftIndex < rightIndex) {
                    nums[leftIndex++] = nums[rightIndex--];
                }
            }
            return leftIndex; // leftIndex⼀定指向了最终数组末尾的下⼀个元素

        }

    }


//    class Solution {
//        public int removeElement(int[] nums, int val) {
//            int size = nums.length;
//            // 暴力破解
//            // 两个循环里都需要使用size，而不是nums.length,size在移动后需要--，不然不能退出循环
//            for (int i=0; i < size; i++){
//                if (nums[i] == val) {
////                    for (int j = i; j < size; j++) {  // 不能这么写，会下标越界
////                        // 后面的元素往前移
////                        nums[j] = nums[j+1];
////                    }
//                    for (int j = i+1; j < size; j++) {
//                        // 后面的元素往前移
//                        nums[j-1] = nums[j];
//                    }
//                    i--;
//                    size--;
//                }
//            }
//            return size;
//        }
//    }

//    class Solution {
//        public int removeElement(int[] nums, int val) {
//            int size = nums.length;
//            for (int i = 0; i < size; i++) {
//                if (nums[i] == val){
//                    for (int j = i+1; j < size; j++) {
//                        nums[j - 1] = nums[j];
//                    }
//                    size--;
//                    i--;
//                }
//            }
//
//            return size;
//        }
//    }


//    class Solution {
//        public int removeElement(int[] nums, int val) {
//            // 双指针法，快指针作为寻找新元素的指针需要遍历所有元素，慢指针指向新数组下标位置
//            int slowIndex = 0;
//            for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
//                if (nums[fastIndex] != val) {
//                    nums[slowIndex] = nums[fastIndex];
//                    slowIndex++;
//                }
//            }
//            return slowIndex;
//        }
//    }
    //leetcode submit region end(Prohibit modification and deletion)

}
