/**
 Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 Example 1:

 Input: n = 3
 Output: [[1,2,3],[8,9,4],[7,6,5]]
 Example 2:

 Input: n = 1
 Output: [[1]]

 Constraints:

 1 <= n <= 20
 */

package main.java.array;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];


        int capacity = matrix.length * matrix[0].length;
        int i = 0, j = 0, fullSpin = 0, filler = 1;

        while (capacity > 0) {
            // right
            while (capacity > 0 && j < matrix[i].length  - fullSpin) {
                matrix[i][j++] = filler++;
                capacity--;
            }
            i++;
            j--;

            // down
            while (capacity > 0 && i < matrix.length - fullSpin) {
                matrix[i++][j] = filler++;
                capacity--;
            }
            i--;
            j--;

            // left
            while (capacity > 0 && j > fullSpin - 1) {
                matrix[i][j--] = filler++;
                capacity--;
            }
            i--;
            j++;

            // up
            while (capacity > 0 && i > fullSpin) {
                matrix[i--][j] = filler++;
                capacity--;
            }
            i++;
            j++;

            fullSpin++;
        }

        return matrix;
    }
}
