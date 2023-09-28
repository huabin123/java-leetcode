//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
// 此外，你可以假设该网格的四条边均被水包围。
//
//
//
// 示例 1：
//
//
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
//
//
// 示例 2：
//
//
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] 的值为 '0' 或 '1'
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2307 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        // Example 1
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int result1 = solution.numIslands(grid1);
        System.out.println("Number of Islands in Example 1: " + result1); // Output: 1

        // Example 2
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int result2 = solution.numIslands(grid2);
        System.out.println("Number of Islands in Example 2: " + result2); // Output: 3
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    // 深搜
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int rows = grid.length;
            int cols = grid[0].length;
            int numIslands = 0;  // 记录找到的岛屿数量

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // 找到“1”，res加一，同时淹没这个岛，防止重复搜索
                    if (grid[i][j] == '1') {
                        numIslands++;
                        dfs(grid, i, j);
                    }
                }
            }

            return numIslands;
        }

        private void dfs(char[][] grid, int row, int col) {
            int rows = grid.length;
            int cols = grid[0].length;

            // 搜索边界：索引越界或遍历到了"0"
            if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
                return;
            }

            grid[row][col] = '0'; // Mark the current cell as visited，淹没岛屿

            // Recursively visit the neighboring cells
            // 根据"每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成"，对上下左右的相邻顶点进行dfs
            dfs(grid, row + 1, col);
            dfs(grid, row - 1, col);
            dfs(grid, row, col + 1);
            dfs(grid, row, col - 1);
        }
    }

    // 广搜
//    class Solution {
//
//        boolean[][] visited;
//        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};  // 定义四个方向
//
//        public int numIslands(char[][] grid) {
//            int res = 0;
//            visited = new boolean[grid.length][grid[0].length];
//            for (int i = 0; i < grid.length; i++) {  // i是行
//                for (int j = 0; j < grid[0].length; j++) {  // j是列
//                    if (!visited[i][j] && grid[i][j] == '1') {  // 广度搜索使用队列，没有递归，这里其实就是终止条件
//                        bfs(grid, i, j);
//                        res++;
//                    }
//                }
//            }
//            return res;
//        }
//
//        // 将这片岛屿上的所有陆地都访问到
//        public void bfs(char[][] grid, int row, int col) {
//            Deque<int[]> queue = new ArrayDeque<>();
//            queue.offer(new int[]{row, col});  // 起始节点加入队列
//            visited[row][col] = true;  // 只要加入队列，立刻标记为访问过的节点
//            while (!queue.isEmpty()) {  // 广度搜索队列里的节点
//                int[] cur = queue.poll();
//                int r = cur[0];
//                int c = cur[1];
//                for (int i = 0; i < 4; i++) {  // 开始向当前节点的四个方向左右上下去遍历
//                    int nexty = r + move[i][0];
//                    int nextx = c + move[i][1];
//                    if (nextx < 0 || nexty == grid.length || nexty < 0 || nextx == grid[0].length) continue;
//                    if (!visited[nexty][nextx] && grid[nexty][nextx] == '1') {
//                        queue.offer(new int[]{nexty, nextx});
//                        visited[nexty][nextx] = true; // 只要加入队列就标记为访问
//                    }
//                }
//            }
//        }
//    }
    //leetcode submit region end(Prohibit modification and deletion)

}
