//在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//
// 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//
// 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的
//。
//
//
//
// 示例 1:
//
//
//输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//输出: 3
//解释:
//从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
//开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
//开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
//开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
//开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
//开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
//因此，3 可为起始索引。
//
// 示例 2:
//
//
//输入: gas = [2,3,4], cost = [3,4,3]
//输出: -1
//解释:
//你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
//我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
//开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
//开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
//你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
//因此，无论怎样，你都不可能绕环路行驶一周。
//
//
//
// 提示:
//
//
// gas.length == n
// cost.length == n
// 1 <= n <= 10⁵
// 0 <= gas[i], cost[i] <= 10⁴
//
//
// Related Topics 贪心 数组 👍 1390 👎 0


package com.huabin.leetcode.editor.cn;
public class GasStation{
    public static void main(String[] args) {
        Solution solution = new GasStation().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int totalGas = 0;  // 总的油量
            int currentGas = 0;  // 当前油量
            int startIndex = 0;  // 起始加油站的索引

            for (int i = 0; i < gas.length; i++) {
                int fuel = gas[i] - cost[i];
                totalGas += fuel;
                currentGas += fuel;

                // 如果当前油量为负数，说明无法从当前加油站出发
                // 将起始加油站设置为下一个加油站，并重置当前油量
                if (currentGas < 0) {
                    startIndex = i + 1;
                    currentGas = 0;
                }
            }

            // 如果总油量大于等于0，说明可以完成环绕
            // 返回起始加油站的索引，否则返回-1表示无法完成
            return totalGas >= 0 ? startIndex : -1;
        }
    }


//    class Solution {
//        public int canCompleteCircuit(int[] gas, int[] cost) {
//            // 思路一：暴力法，遍历每一个加油站为起点的情况，模拟一圈。
//            // 如果跑了一圈，中途没有断油，而且最后油量大于等于0，说明这个起点是ok的。
//            for (int i = 0; i < cost.length; i++) {
//                int rest = gas[i] - cost[i];  // 记录剩余油量
//                int index = (i + 1) % cost.length;  // 这一行作用是计算下一个加油站的索引，以便在模拟环绕一圈的过程中遍历所有的加油站。
//                while (rest > 0 && index != i) {  // 模拟以i为起点行驶一圈（如果有rest==0，那么答案就不唯一了）
//                    rest += gas[index] - cost[index];
//                    index = (index + 1) % cost.length;
//                }
//                // 如果以i为起点跑一圈，剩余油量>=0，返回该起点位置
//                if (rest >= 0 && index == i) {
//                    return i;
//                }
//            }
//            return -1;
//        }
//    }
    //leetcode submit region end(Prohibit modification and deletion)

}
