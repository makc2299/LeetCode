/**
 Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

 If target is not found in the array, return [-1, -1].

 You must write an algorithm with O(log n) runtime complexity.

 Example 1:

 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]
 Example 2:

 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]
 Example 3:

 Input: nums = [], target = 0
 Output: [-1,-1]

 Constraints:

 0 <= nums.length <= 105
 -109 <= nums[i] <= 109
 nums is a non-decreasing array.
 -109 <= target <= 109
 */

package main.java.array;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        int idx = binarySearch(nums, target);

        if (idx == -1) {
            ans[0] = -1;
            ans[1] = -1;
        } else {
            int left = idx;
            while (left != -1 && nums[left] == nums[idx]) {
                left--;
            }

            int right = idx;
            while (right != nums.length && nums[right] == nums[idx]) {
                right++;
            }
            ans[0] = ++left;
            ans[1] = --right;
        }

        return ans;
    }

    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
