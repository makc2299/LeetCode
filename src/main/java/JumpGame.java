/**
 You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

 Return true if you can reach the last index, or false otherwise.

 Example 1:

 Input: nums = [2,3,1,1,4]
 Output: true
 Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Example 2:

 Input: nums = [3,2,1,0,4]
 Output: false
 Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

 Constraints:

 1 <= nums.length <= 104
 0 <= nums[i] <= 105
 */

package main.java;

public class JumpGame {

    // https://leetcode.com/problems/jump-game/solutions/4481995/extremely-easy-solution/
    public boolean canJump1(int[] nums) {
        int jump = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (jump < nums[i]) {
                jump = nums[i];
            }

            if (jump-- == 0) return false;
        }

        return true;
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int maxValueIdx, valueWithDistance;
        for (int i = 0; i < nums.length && nums[i] != 0; i = maxValueIdx) {
            maxValueIdx = i + 1;
            valueWithDistance = nums[maxValueIdx] - (nums.length - maxValueIdx);
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j == nums.length - 1) {
                    return true;
                }

                if (nums[i + j] == 0) {
                    continue;
                }

                int tmp = nums[i + j] - (nums.length - (i + j));
                if (tmp >= valueWithDistance) {
                    maxValueIdx = i + j;
                    valueWithDistance = tmp;
                }
            }
        }

        return false;
    }
}
