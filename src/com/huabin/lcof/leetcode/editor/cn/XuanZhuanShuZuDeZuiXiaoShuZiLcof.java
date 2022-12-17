//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//
// 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3
//,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
//
// 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2],
//..., a[n-2]] 。
//
//
//
// 示例 1：
//
//
//输入：numbers = [3,4,5,1,2]
//输出：1
//
//
// 示例 2：
//
//
//输入：numbers = [2,2,2,0,1]
//输出：0
//
//
//
//
// 提示：
//
//
// n == numbers.length
// 1 <= n <= 5000
// -5000 <= numbers[i] <= 5000
// numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
//
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-
//sorted-array-ii/
// Related Topics 数组 二分查找 👍 732 👎 0


package com.huabin.lcof.leetcode.editor.cn;

/**
 * 面试题8：旋转数组的最小数字
 */
public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {

    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
//        int[] array = new int[] {1,1,0,1,1};
        int[] array = new int[] {3,4,1,2};
        System.out.println(solution.minArray(array));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minArray(int[] numbers) {

            int length = numbers.length;
            if(length == 0) {
                return 0;
            }
            // i永远为前一个非递减的数组指针
            int i= 0;
            // j永远为后一个非递减的数组指针
            int j= length-1;
            // middle永远指向中间的值，当旋转数据就是原数组时，返回第1个数字
            int middle = i;
            while (numbers[i] >= numbers[j]) {
                if ((j - i) == 1) {
                    middle = j;
                    break;
                }
                middle = (j + i) / 2;
                // 如果下标i, j, middle 指向的三个数字相等，就只能顺序查找（这个也需要技巧）
                if (numbers[middle] == numbers[i] && numbers[middle] == numbers[j]) {
                    return minNumberArray(numbers, i, j);
                }

                if (numbers[middle] >= numbers[i]) {
                    i = middle;
                } else if (numbers[middle] <= numbers[j]){
                    j = middle;
                }
            }

            return numbers[middle];
        }

        /**
         * 顺序找出旋转数组中最小的值
         * 因为有序，只要找到第一个递减的值就可以返回了
         * @param array
         * @param index1
         * @param index2
         * @return
         */
        public int minNumberArray(int [] array, int index1, int index2) {
            int result = array[index1];
            for (int i = index1; i < index2-1; i++) {
                result = array[i];
                if (result > array[i+1]) {
                    return array[i+1];
                }
            }
            return result;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
