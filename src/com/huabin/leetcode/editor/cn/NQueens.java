//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//
//
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
//
//
// 示例 1：
//
//
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[["Q"]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 9
//
//
// Related Topics 数组 回溯 👍 1893 👎 0


package com.huabin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens{
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            // 先构造出棋盘
            char[][] chessboard = new char[n][n];
            // 用.填充棋盘
            for (char[] chars : chessboard) {
                Arrays.fill(chars, '.');
            }
            this.backTrack(n, 0, chessboard);
            return res;
        }

        /**
         *
         * @param n
         * @param row 当前的层数
         * @param chessboard
         */
        private void backTrack(int n, int row, char[][] chessboard) {
            if (row == n) {
                res.add(this.arry2List(chessboard));
            }
            for (int col = 0; col < n; col++) {
                if(this.isValid(chessboard, n, row, col)){
                    chessboard[row][col] = 'Q';
                    backTrack(n, row + 1, chessboard);
                    chessboard[row][col] = '.';
                }
            }
        }

        private boolean isValid(char[][] chessboard, int n, int row, int col) {
            // 检查列
            for (int i = 0; i < row; ++i) { // 相当于剪枝
                if (chessboard[i][col] == 'Q') {
                    return false;
                }
            }

            // 检查45度对角线
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (chessboard[i][j] == 'Q') {
                    return false;
                }
            }

            // 检查135度对角线
            for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
                if (chessboard[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }

        private List<String> arry2List(char[][] chessboard) {
            List<String> list = new ArrayList<>();

            for (char[] c : chessboard) {
                list.add(String.copyValueOf(c));
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
