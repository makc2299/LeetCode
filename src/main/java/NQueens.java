/**
 The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

 Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 Example 1:

 Input: n = 4
 Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 Example 2:

 Input: n = 1
 Output: [["Q"]]

 Constraints:

 1 <= n <= 9
 */

package main.java;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    List<List<String>> ans = new ArrayList<>();
    int QUEEN = 1;
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];

        solver(board, 0);

        return ans;
    }

    public void solver(int[][] board, int j) {
        for (int i = 0; i < board.length; i++) {
            if (!isQueenAttack(board, i, j)) {
                if (j == board[i].length - 1) {
                    board[i][j] = QUEEN;
                    ans.add(boardToList(board));
                    board[i][j] = 0;
                    continue;
                }

                board[i][j] = QUEEN;
                solver(board, j + 1);
                board[i][j] = 0;
            }
        }
    }

    private boolean isQueenAttack(int[][] board, int i, int j) {
        return isHorizontalAttack(board, i, j) || isDiagonalAttack(board, i, j);
    }

    private boolean isHorizontalAttack(int[][] board, int i, int j) {
        for (int l = j - 1; l > -1 ; l--) {
            if (board[i][l] == QUEEN) {
                return true;
            }
        }

        for (int r = j + 1; r < board[i].length; r++) {
            if (board[i][r] == QUEEN) {
                return true;
            }
        }

        return false;
    }

    private boolean isVerticalAttack(int[][] board, int i, int j) {
        for (int u = i - 1; u > -1; u--) {
            if (board[u][j] == QUEEN) {
                return true;
            }
        }

        for (int d = i + 1; d < board.length; d++) {
            if (board[d][j] == QUEEN) {
                return true;
            }
        }

        return false;
    }

    private boolean isDiagonalAttack(int[][] board, int i, int j) {
        for (int rui = i - 1, ruj = j + 1; rui > -1 && ruj < board[i].length ; rui--, ruj++) {
            if (board[rui][ruj] == QUEEN) {
                return true;
            }
        }

        for (int lui = i - 1, luj = j - 1; lui > -1 && luj > -1 ; lui--, luj--) {
            if (board[lui][luj] == QUEEN) {
                return true;
            }
        }

        for (int rdi = i + 1, rdj = j + 1; rdi < board.length && rdj < board[i].length; rdi++, rdj++) {
            if (board[rdi][rdj] == QUEEN) {
                return true;
            }
        }

        for (int ldi = i + 1, ldj = j - 1; ldi < board.length && ldj > -1; ldi++, ldj--) {
            if (board[ldi][ldj] == QUEEN) {
                return true;
            }
        }

        return false;
    }

    private List<String> boardToList(int[][] board) {
        List<String> boardAsStrings = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    stringBuilder.append('.');
                } else {
                    stringBuilder.append('Q');
                }
            }
            boardAsStrings.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }

        return boardAsStrings;
    }
}
