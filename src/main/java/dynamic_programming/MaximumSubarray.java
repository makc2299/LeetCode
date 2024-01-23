/**
 Given an integer array nums, find the subarray with the largest sum, and return its sum.

 Example 1:

 Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 Output: 6
 Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 Example 2:

 Input: nums = [1]
 Output: 1
 Explanation: The subarray [1] has the largest sum 1.
 Example 3:

 Input: nums = [5,4,-1,7,8]
 Output: 23
 Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

 Constraints:

 1 <= nums.length <= 105
 -104 <= nums[i] <= 104

 Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

package main.java.dynamic_programming;

public class MaximumSubarray {

    int[] arr;
    int max = Integer.MIN_VALUE;

    // https://leetcode.com/problems/maximum-subarray/solutions/3666304/beats-100-c-java-python-beginner-friendly/
    public int maxSubArray1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        arr = new int[nums.length];
        max = Math.max(dp(nums, nums.length - 1), max);

        return max;
    }

    private int dp(int[] nums, int i) {
        if (i == 0) {
            arr[i] = nums[0];
            return nums[0];
        }
        int tmp = dp(nums, i - 1);
        max = Math.max(tmp, max);
        arr[i] = nums[i] + Math.max(0, tmp);

        return arr[i];
    }

}
