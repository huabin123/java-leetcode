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
        int[] array = new int[] {10,1,10,10,10};
//        int[] array = new int[] {1,3,5};
//        int[] array = new int[] {1,1,0,1,1};
//        int[] array = new int[] {3,4,5,6,-1,1,2};
        System.out.println(solution.minArray(array));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minArray(int[] numbers) {
            int startIndex = 0;
            int endIndex = numbers.length - 1;

            // {1,3,5}
            if (numbers[endIndex] > numbers[startIndex]) {
                return numbers[startIndex];
            }

            while (endIndex - startIndex > 1) {
                int mid = (startIndex + endIndex) / 2;

                if (numbers[mid] == numbers[startIndex] && numbers[mid] == numbers[endIndex]) {
                    // 三个位置都相等的情况只能顺序查找 {10,1,10,10,10}
                    int res = numbers[startIndex];
                    for (int i = startIndex+1; i < endIndex+1; i++) {
                        if (numbers[i] < res) {
                            res = numbers[i];
                        }
                    }
                    return res;
                }

                if(numbers[mid] >= numbers[startIndex]) {
                    startIndex = mid;
                }else {
                    endIndex = mid;
                }
            }
            return numbers[endIndex];
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
