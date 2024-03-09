/**
 Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 Example 1:

 Input: heights = [2,1,5,6,2,3]
 Output: 10
 Explanation: The above is a histogram where width of each bar is 1.
 The largest rectangle is shown in the red area, which has an area = 10 units.
 Example 2:

 Input: heights = [2,4]
 Output: 4

 Constraints:

 1 <= heights.length <= 105
 0 <= heights[i] <= 104
 */

package main.java.array;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int maxSquare = 0, tmpSquare;
        
        int l, r;
        for (int i = 0; i < heights.length; i++) {
            l = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    break;
                }
                l++;
            }

            r = 0;
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < heights[i]) {
                    break;
                }
                r++;
            }

            tmpSquare = (l + r + 1) * heights[i];
            if (tmpSquare > maxSquare) {
                maxSquare = tmpSquare;
            }
        }

        return maxSquare;
    }

    public int largestRectangleArea1(int[] heights) {
        int maxSquare = 0, tmpSquare;

        int[] leftFSE = LFSE(heights);
        int[] rightFSE = RFSE(heights);

        System.out.println(Arrays.toString(leftFSE));
        System.out.println(Arrays.toString(rightFSE));

        int l, r;
        for (int i = 0; i < heights.length; i++) {
            l = leftFSE[i] + 1;
            r = rightFSE[i] - 1;

            tmpSquare = (r - l + 1) * heights[i];
            if (tmpSquare > maxSquare) {
                maxSquare = tmpSquare;
            }
        }

        return maxSquare;
    }

    private int[] LFSE(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = stack.peek();
            }

            stack.push(i);
        }

        return pse;
    }

    private int[] RFSE(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] fse = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                fse[i] = heights.length;
            } else {
                fse[i] = stack.peek();
            }

            stack.push(i);
        }

        return fse;
    }

    public int largestRectangleArea2(int[] heights) {
        int maxSquare = 0;
        Stack<Integer> height = new Stack<>();
        Stack<Integer> position = new Stack<>();

        int h = 0, p = 0, i = 0;
        for (i = 0; i < heights.length; i++) {
            if (height.isEmpty() || heights[i] > height.peek()) {
                height.push(heights[i]);
                position.push(i);
            } else if (heights[i] < height.peek()) {
                while (!height.isEmpty() && heights[i] < height.peek()) {
                    h = height.pop();
                    p = position.pop();
                    maxSquare = Math.max((h * (i - p)), maxSquare);
                }
                height.push(heights[i]);
                position.push(p);
            }

        }

        while (!height.isEmpty()) {
            maxSquare = Math.max((height.pop() * (heights.length - position.pop())), maxSquare);
        }

        return maxSquare;
    }
}
