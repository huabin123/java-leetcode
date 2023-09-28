//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
//
//
//
// 示例 1：
//
//
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
//
//
// 示例 2：
//
//
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 500
// grid[i][j] 的值为 0 或 1
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 234 👎 0


package com.huabin.leetcode.editor.cn;
public class NumberOfEnclaves{
    public static void main(String[] args) {
        Solution solution = new NumberOfEnclaves().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numEnclaves(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int rows = grid.length;
            int cols = grid[0].length;

            // 首先，将所有边界上的陆地及其相连的陆地深度优先搜索标记为已访问
            for (int i = 0; i < rows; i++) {
                if (grid[i][0] == 1) {
                    dfs(grid, i, 0);
                }
                if (grid[i][cols - 1] == 1) {
                    dfs(grid, i, cols - 1);
                }
            }
            for (int j = 0; j < cols; j++) {
                if (grid[0][j] == 1) {
                    dfs(grid, 0, j);
                }
                if (grid[rows - 1][j] == 1) {
                    dfs(grid, rows - 1, j);
                }
            }

            // 统计剩余的陆地（内部陆地）的数量
            int count = 0;
            for (int i = 1; i < rows - 1; i++) {
                for (int j = 1; j < cols - 1; j++) {
                    if (grid[i][j] == 1) {
                        count++;
                    }
                }
            }

            return count;
        }

        private void dfs(int[][] grid, int row, int col) {
            int rows = grid.length;
            int cols = grid[0].length;

            // 搜索边界：索引越界或遍历到了"0"
            if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
                return;
            }

            grid[row][col] = 0; // 标记当前陆地为已访问

            // 递归访问上下左右的相邻陆地
            dfs(grid, row + 1, col);
            dfs(grid, row - 1, col);
            dfs(grid, row, col + 1);
            dfs(grid, row, col - 1);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
