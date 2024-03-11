/**
 Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 Example 1:

 Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 Output: 6
 Explanation: The maximal rectangle is shown in the above picture.
 Example 2:

 Input: matrix = [["0"]]
 Output: 0
 Example 3:

 Input: matrix = [["1"]]
 Output: 1

 Constraints:

 rows == matrix.length
 cols == matrix[i].length
 1 <= row, cols <= 200
 matrix[i][j] is '0' or '1'.
 */

package main.java.array;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int[] hist = new int[matrix[0].length];
        int maxRect = 0;

        largestRectSquare(new int[] {2, 3});

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int num = matrix[i][j] - '0';
                if (num == 0) {
                    hist[j] = 0;
                } else {
                    hist[j] += num;
                }
            }
            maxRect = Math.max(largestRectSquare(hist), maxRect);
        }

        return maxRect;
    }

    private int largestRectSquare(int[] hist) {
        Stack<Integer> heights = new Stack<>();
        Stack<Integer> positions = new Stack<>();
        int maxSquare = 0, h = 0, p = 0;

        for (int i = 0; i < hist.length; i++) {
            if (heights.isEmpty() || heights.peek() < hist[i]) {
                heights.push(hist[i]);
                positions.push(i);
            } else if (heights.peek() > hist[i]) {
                while (!heights.isEmpty() && heights.peek() > hist[i]) {
                    h = heights.pop();
                    p = positions.pop();
                    maxSquare = Math.max(h * (i - p), maxSquare);
                }
                heights.push(hist[i]);
                positions.push(p);
            }

        }

        while (!heights.isEmpty()) {
            maxSquare = Math.max((heights.pop() * (hist.length - positions.pop())), maxSquare);
        }

        return maxSquare;
    }
}
