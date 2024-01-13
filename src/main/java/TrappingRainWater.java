/**
 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 Example 1:

 Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6
 Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 Example 2:

 Input: height = [4,2,0,3,2,5]
 Output: 9

 Constraints:

 n == height.length
 1 <= n <= 2 * 104
 0 <= height[i] <= 105
 */

package main.java;

public class TrappingRainWater {

    // https://leetcode.com/problems/trapping-rain-water/solutions/3401992/100-detailed-explaination-with-pictures-in-c-java-python-two-pointers/
    public int trap2(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int water = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
            } else {
                right--;
                if (rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
            }
        }
        return water;
    }

    public int trap1(int[] height) {
        int water = 0, maxLeftIdx = 0, maxRightIdx = 0;
        for (int i = 1; i < height.length - 1; i++) {
            if (i >= maxRightIdx || height[i] > height[maxLeftIdx]) {
                maxLeftIdx = findHighest(height, 0, i);
                maxRightIdx = findHighest(height, i, height.length - 1);
            }
            water += Math.min(height[maxLeftIdx], height[maxRightIdx]) - height[i];
        }

        return water;
    }

    public int trap(int[] height) {
        int highestIdx = findHighest(height, 0, height.length - 1);

        return left(height, highestIdx - 1) + right(height, highestIdx + 1);
    }

    private int left(int[] height,  int rightIdx) {
        if (rightIdx < 1) {
            return 0;
        }

        int highestIdx = findHighest(height, 0, rightIdx);
        int water = 0;
        for (int i = highestIdx + 1; i <= rightIdx; i++) {
            water += height[highestIdx] - height[i];
        }

        return left(height, highestIdx - 1) + water;
    }

    private int right(int[] height, int leftIdx) {
        if (leftIdx > height.length - 2) {
            return 0;
        }

        int highestIdx = findHighest(height, leftIdx, height.length - 1);
        int water = 0;
        for (int i = leftIdx; i <= highestIdx ; i++) {
            water += height[highestIdx] - height[i];
        }

        return water + right(height, highestIdx + 1);
    }

    public int findHighest(int[] height, int b1, int b2) {
        int highestIdx = b1;
        for (int i = b1; i <= b2; i++) {
            if (height[i] > height[highestIdx]) {
                highestIdx = i;
            }
        }
        return highestIdx;
    }
}
