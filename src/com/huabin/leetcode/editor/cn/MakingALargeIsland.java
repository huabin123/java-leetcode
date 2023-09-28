//给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
//
// 返回执行此操作后，grid 中最大的岛屿面积是多少？
//
// 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
//
//
//
// 示例 1:
//
//
//输入: grid = [[1, 0], [0, 1]]
//输出: 3
//解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
//
//
// 示例 2:
//
//
//输入: grid = [[1, 1], [1, 0]]
//输出: 4
//解释: 将一格0变成1，岛屿的面积扩大为 4。
//
// 示例 3:
//
//
//输入: grid = [[1, 1], [1, 1]]
//输出: 4
//解释: 没有0可以让我们变成1，面积依然为 4。
//
//
//
// 提示：
//
//
// n == grid.length
// n == grid[i].length
// 1 <= n <= 500
// grid[i][j] 为 0 或 1
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 365 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland{
    public static void main(String[] args) {
        Solution solution = new MakingALargeIsland().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestIsland(int[][] grid) {
            int n = grid.length;
            int maxIslandSize = 0;
            int currentIslandSize = 0;

            // 使用DFS标记每个岛屿，并记录岛屿的大小
            Map<Integer, Integer> islandSizes = new HashMap<>();
            int islandId = 2; // 1表示海洋，2及以上表示不同的岛屿
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        currentIslandSize = dfs(grid, i, j, islandId);
                        islandSizes.put(islandId, currentIslandSize);
                        maxIslandSize = Math.max(maxIslandSize, currentIslandSize);
                        islandId++;
                    }
                }
            }

            // 遍历海洋的每个'0'，尝试合并相邻的岛屿
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        Set<Integer> adjacentIslandIds = new HashSet<>();
                        for (int[] dir : directions) {
                            int x = i + dir[0];
                            int y = j + dir[1];
                            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] != 0) {
                                adjacentIslandIds.add(grid[x][y]);
                            }
                        }

                        int totalSize = 1; // 记录当前海洋单元格的大小
                        for (int id : adjacentIslandIds) {
                            totalSize += islandSizes.get(id);
                        }
                        maxIslandSize = Math.max(maxIslandSize, totalSize);
                    }
                }
            }

            return maxIslandSize;
        }

        private int dfs(int[][] grid, int row, int col, int islandId) {
            int n = grid.length;
            if (row < 0 || row >= n || col < 0 || col >= n || grid[row][col] != 1) {
                return 0;
            }

            grid[row][col] = islandId; // 标记为已访问
            int size = 1;
            size += dfs(grid, row + 1, col, islandId);
            size += dfs(grid, row - 1, col, islandId);
            size += dfs(grid, row, col + 1, islandId);
            size += dfs(grid, row, col - 1, islandId);

            return size;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
