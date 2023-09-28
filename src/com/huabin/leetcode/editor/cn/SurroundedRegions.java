//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
//
//
// 示例 2：
//
//
//输入：board = [["X"]]
//输出：[["X"]]
//
//
//
//
// 提示：
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] 为 'X' 或 'O'
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1023 👎 0


package com.huabin.leetcode.editor.cn;
public class SurroundedRegions{
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 逆向思维，先将边框部分用深搜标记为*，再将所有O变成X，最后将*还原为O
         * @param board
         */
        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) {
                return;
            }

            int rows = board.length;
            int cols = board[0].length;

            // 遍历第一列和最后一列，将与边界相连的'O'进行DFS标记
            for (int i = 0; i < rows; i++) {
                if (board[i][0] == 'O') {
                    dfs(board, i, 0);
                }
                if (board[i][cols - 1] == 'O') {
                    dfs(board, i, cols - 1);
                }
            }

            // 遍历第一行和最后一行，将与边界相连的'O'进行DFS标记
            for (int j = 0; j < cols; j++) {
                if (board[0][j] == 'O') {
                    dfs(board, 0, j);
                }
                if (board[rows - 1][j] == 'O') {
                    dfs(board, rows - 1, j);
                }
            }

            // 将剩余的'O'标记为'X'，将标记为'*'的还原为'O'
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == '*') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void dfs(char[][] board, int row, int col) {
            int rows = board.length;
            int cols = board[0].length;

            if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O') {
                return;
            }

            board[row][col] = '*'; // 标记当前'O'为已访问

            // 递归访问上下左右的相邻'O'
            dfs(board, row + 1, col);
            dfs(board, row - 1, col);
            dfs(board, row, col + 1);
            dfs(board, row, col - 1);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
