/**
 The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

 Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 Example 1:

 Input: n = 4
 Output: 2
 Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 Example 2:

 Input: n = 1
 Output: 1

 Constraints:

 1 <= n <= 9
 */

package main.java;

public class NQueensII {

    int distinctSolutions = 0;
    int QUEEN = 1;

    public int totalNQueens(int n) {
        int[][] board = new int[n][n];

        solver(board, 0);

        return distinctSolutions;
    }

    public void solver(int[][] board, int j) {
        for (int i = 0; i < board.length; i++) {
            if (!isQueenAttack(board, i, j)) {
                if (j == board[i].length - 1) {
                    board[i][j] = QUEEN;
                    distinctSolutions++;
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

}
