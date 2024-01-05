/**
 Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

 Each row must contain the digits 1-9 without repetition.
 Each column must contain the digits 1-9 without repetition.
 Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 Note:

 A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 Only the filled cells need to be validated according to the mentioned rules.


 Example 1:

 Input: board =
 [["5","3",".",".","7",".",".",".","."]
 ,["6",".",".","1","9","5",".",".","."]
 ,[".","9","8",".",".",".",".","6","."]
 ,["8",".",".",".","6",".",".",".","3"]
 ,["4",".",".","8",".","3",".",".","1"]
 ,["7",".",".",".","2",".",".",".","6"]
 ,[".","6",".",".",".",".","2","8","."]
 ,[".",".",".","4","1","9",".",".","5"]
 ,[".",".",".",".","8",".",".","7","9"]]
 Output: true
 Example 2:

 Input: board =
 [["8","3",".",".","7",".",".",".","."]
 ,["6",".",".","1","9","5",".",".","."]
 ,[".","9","8",".",".",".",".","6","."]
 ,["8",".",".",".","6",".",".",".","3"]
 ,["4",".",".","8",".","3",".",".","1"]
 ,["7",".",".",".","2",".",".",".","6"]
 ,[".","6",".",".",".",".","2","8","."]
 ,[".",".",".","4","1","9",".",".","5"]
 ,[".",".",".",".","8",".",".","7","9"]]
 Output: false
 Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

 Constraints:

 board.length == 9
 board[i].length == 9
 board[i][j] is a digit 1-9 or '.'.
 */

package main.java;

import java.util.ArrayList;
import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rowCol = new HashSet<>();
        ArrayList<HashSet<Character>> boxes = new ArrayList<>();
        boxes.add(new HashSet<>());
        boxes.add(new HashSet<>());
        boxes.add(new HashSet<>());

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (!rowCol.add(board[i][j])) {
                    return false;
                }

                if (!boxes.get(j / 3).add(board[i][j])) {
                    return false;
                }
            }
            if ((i + 1) % 3 == 0) {
                boxes.get(0).clear();
                boxes.get(1).clear();
                boxes.get(2).clear();
            }
            rowCol.clear();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (!rowCol.add(board[j][i])) {
                    return false;
                }
            }
            rowCol.clear();
        }
        return true;
    }
    
}
