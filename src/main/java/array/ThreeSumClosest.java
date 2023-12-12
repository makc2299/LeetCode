/**
 Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 Return the sum of the three integers.
 You may assume that each input would have exactly one solution.

 Example 1:

 Input: nums = [-1,2,1,-4], target = 1
 Output: 2
 Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 Example 2:

 Input: nums = [0,0,0], target = 1
 Output: 0
 Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

 Constraints:

 3 <= nums.length <= 500
 -1000 <= nums[i] <= 1000
 -104 <= target <= 104
 */

package main.java.array;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i, j ,k, sum, output = Integer.MAX_VALUE;

        for (i = 0; i < nums.length - 2; i++) {
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];

                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    return sum;
                }

                if (Math.abs(target - sum) < Math.abs(target - output)) {
                    output = sum;
                }
            }
        }
        return output;
    }
}
