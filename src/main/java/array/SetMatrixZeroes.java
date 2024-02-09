/**
 Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

 You must do it in place.

 Example 1:

 Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 Output: [[1,0,1],[0,0,0],[1,0,1]]
 Example 2:

 Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

 Constraints:

 m == matrix.length
 n == matrix[0].length
 1 <= m, n <= 200
 -231 <= matrix[i][j] <= 231 - 1

 Follow up:

 A straightforward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?
 */

package main.java.array;

import java.util.Arrays;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    Arrays.fill(matrix[0], 0);
                    return;
                }
            }
        } else if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 0; j < matrix.length; j++) {
                        matrix[j][0] = 0;
                    }
                }
            }
            return;
        }


        int start = matrix[0][0];
        boolean firstLine = false;
        boolean firstCol = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (j == 0) {
                        firstCol = true;
                    }

                    matrix[i][0] = 0;
                    if (i == 0) {
                        firstLine = true;
                    }
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (start == 0) {
            for (int i = 1; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        } else {
            if (firstLine) {
                Arrays.fill(matrix[0], 0);
            }
            if (firstCol) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }

    }
}
