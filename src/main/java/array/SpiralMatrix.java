/**
 Given an m x n matrix, return all elements of the matrix in spiral order.

 Example 1:

 Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 Output: [1,2,3,6,9,8,7,4,5]
 Example 2:

 Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 Constraints:

 m == matrix.length
 n == matrix[i].length
 1 <= m, n <= 10
 -100 <= matrix[i][j] <= 100
 */

package main.java.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int capacity = matrix.length * matrix[0].length;
        int i = 0, j = 0, fullSpin = 0;

        while (capacity > 0) {
            // right
            while (capacity > 0 && j < matrix[i].length  - fullSpin) {
                ans.add(matrix[i][j++]);
                capacity--;
            }
            i++;
            j--;

            // down
            while (capacity > 0 && i < matrix.length - fullSpin) {
                ans.add(matrix[i++][j]);
                capacity--;
            }
            i--;
            j--;

            // left
            while (capacity > 0 && j > fullSpin - 1) {
                ans.add(matrix[i][j--]);
                capacity--;
            }
            i--;
            j++;

            // up
            while (capacity > 0 && i > fullSpin) {
                ans.add(matrix[i--][j]);
                capacity--;
            }
            i++;
            j++;

            fullSpin++;
        }

        return ans;
    }
}
