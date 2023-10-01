//有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候
//进入锁住的房间。 
//
// 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。 
//
// 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：rooms = [[1],[2],[3],[]]
//输出：true
//解释：
//我们从 0 号房间开始，拿到钥匙 1。
//之后我们去 1 号房间，拿到钥匙 2。
//然后我们去 2 号房间，拿到钥匙 3。
//最后我们去了 3 号房间。
//由于我们能够进入每个房间，我们返回 true。
// 
//
// 示例 2： 
//
// 
//输入：rooms = [[1,3],[3,0,1],[2],[0]]
//输出：false
//解释：我们不能进入 2 号房间。
// 
//
// 
//
// 提示： 
//
// 
// n == rooms.length 
// 2 <= n <= 1000 
// 0 <= rooms[i].length <= 1000 
// 1 <= sum(rooms[i].length) <= 3000 
// 0 <= rooms[i][j] < n 
// 所有 rooms[i] 的值 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 👍 339 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KeysAndRooms{
    public static void main(String[] args) {
         Solution solution = new KeysAndRooms().new Solution();

        // 测试案例 1：可以访问所有房间
        List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(Collections.singletonList(1));
        rooms1.add(Collections.singletonList(2));
        rooms1.add(Collections.singletonList(3));
        rooms1.add(new ArrayList<>());
        boolean result1 = solution.canVisitAllRooms(rooms1);
        System.out.println("Test Case 1: " + result1); // 应输出 true

        // 测试案例 2：无法访问所有房间
        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(Arrays.asList(1, 3));
        rooms2.add(Arrays.asList(3, 0, 1));
        rooms2.add(Collections.singletonList(2));
        rooms2.add(Collections.singletonList(0));
        boolean result2 = solution.canVisitAllRooms(rooms2);
        System.out.println("Test Case 2: " + result2); // 应输出 false
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private void dfs(int key, List<List<Integer>>  rooms, List<Boolean> visited) {
            if (visited.get(key)) {
                return;
            }
            visited.set(key, true);
            for (int k : rooms.get(key)) {
                // 深度优先搜索遍历
                dfs(k, rooms, visited);
            }
        }
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            List<Boolean> visited = new ArrayList<Boolean>(){{
                for(int i = 0 ; i < rooms.size(); i++){
                    add(false);
                }
            }};
            dfs(0, rooms, visited);
            //检查是否都访问到了
            for (boolean flag : visited) {
                if (!flag) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}