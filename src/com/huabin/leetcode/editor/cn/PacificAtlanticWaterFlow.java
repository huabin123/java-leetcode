//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
//
// 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可
//流向大西洋 。
//
//
//
// 示例 1：
//
//
//
//
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
//
//
// 示例 2：
//
//
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
//
//
//
//
// 提示：
//
//
// m == heights.length
// n == heights[r].length
// 1 <= m, n <= 200
// 0 <= heights[r][c] <= 10⁵
//
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 635 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow{
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 题意是：水往低处流，找出哪些单元格的水可以流向太平洋和大西洋
         * 思路：通过深度优先搜索（DFS）从太平洋和大西洋的边界开始标记能够到达的单元格，并最终找到既可以到达太平洋又可以到达大西洋的单元格。
         * @param matrix
         * @return
         */
        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            List<List<Integer>> result = new ArrayList<>();

            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return result;
            }

            int rows = matrix.length;
            int cols = matrix[0].length;
            boolean[][] canReachPacific = new boolean[rows][cols];
            boolean[][] canReachAtlantic = new boolean[rows][cols];

            // 从太平洋边界开始DFS
            for (int i = 0; i < rows; i++) {
                dfs(matrix, canReachPacific, i, 0);
                dfs(matrix, canReachAtlantic, i, cols - 1);
            }

            for (int j = 0; j < cols; j++) {
                dfs(matrix, canReachPacific, 0, j);
                dfs(matrix, canReachAtlantic, rows - 1, j);
            }

            // 找出既可以到达太平洋又可以到达大西洋的单元格
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                        List<Integer> cell = new ArrayList<>();
                        cell.add(i);
                        cell.add(j);
                        result.add(cell);
                    }
                }
            }

            return result;
        }

        private void dfs(int[][] matrix, boolean[][] canReach, int x, int y) {
            canReach[x][y] = true;

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length
                        && !canReach[newX][newY] && matrix[newX][newY] >= matrix[x][y]) {
                    dfs(matrix, canReach, newX, newY);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
