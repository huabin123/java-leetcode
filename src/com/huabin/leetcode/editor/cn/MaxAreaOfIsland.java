//给你一个大小为 m x n 的二进制矩阵 grid 。
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。
//
// 岛屿的面积是岛上值为 1 的单元格的数目。
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
//
//
//
// 示例 1：
//
//
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
//
//
// 示例 2：
//
//
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// grid[i][j] 为 0 或 1
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1007 👎 0


package com.huabin.leetcode.editor.cn;
public class MaxAreaOfIsland{
    public static void main(String[] args) {
        Solution solution = new MaxAreaOfIsland().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int rows = grid.length;
            int cols = grid[0].length;
            int res = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // 找到1，res加一，同时淹没这个岛，防止重复搜索
                    if (grid[i][j] == 1) {
                        int num = dfs(grid, i, j);
                        res = Math.max(res, num);
                    }
                }
            }

            return res;
        }

        private int dfs(int[][] grid, int row, int col) {
            int rows = grid.length;
            int cols = grid[0].length;

            // 搜索边界：索引越界或遍历到了"0"
            if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
                return 0;
            }

            grid[row][col] = 0; // Mark the current cell as visited，淹没岛屿

            int size = 1;
            // Recursively visit the neighboring cells
            // 根据"每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成"，对上下左右的相邻顶点进行dfs
            size += dfs(grid, row + 1, col);
            size += dfs(grid, row - 1, col);
            size += dfs(grid, row, col + 1);
            size += dfs(grid, row, col - 1);

            return size;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
