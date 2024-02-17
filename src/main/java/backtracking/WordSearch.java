/**
 Given an m x n grid of characters board and a string word, return true if word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 Example 1:

 Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 Output: true
 Example 2:

 Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 Output: true
 Example 3:

 Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 Output: false

 Constraints:

 m == board.length
 n = board[i].length
 1 <= m, n <= 6
 1 <= word.length <= 15
 board and word consists of only lowercase and uppercase English letters.


 Follow up: Could you use search pruning to make your solution faster with a larger board?
 */

package main.java.backtracking;

public class WordSearch {

    boolean[][] hash;

    public boolean exist(char[][] board, String word) {
        hash = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (isWordExist(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean isWordExist(char[][] board, int i, int j, String word, int idx) {
        if (i < 0 || i >= board.length) {
            return false;
        }
        if (j < 0 || j >= board[i].length) {
            return false;
        }

        boolean ans = false;
        if (board[i][j] == word.charAt(idx)) {
            if (hash[i][j]) {
                return false;
            }

            if (idx == word.length() - 1) {
                return true;
            }

            hash[i][j] = true;

            ans = isWordExist(board, i - 1, j, word, idx + 1) ||
                    isWordExist(board, i, j + 1, word, idx + 1) ||
                    isWordExist(board, i + 1, j, word, idx + 1) ||
                    isWordExist(board, i, j - 1, word, idx + 1);

            hash[i][j] = false;
        }

        return ans;
    }
}
