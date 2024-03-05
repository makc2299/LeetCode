/**
 There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

 Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

 Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

 You must decrease the overall operation steps as much as possible.

 Example 1:

 Input: nums = [2,5,6,0,0,1,2], target = 0
 Output: true
 Example 2:

 Input: nums = [2,5,6,0,0,1,2], target = 3
 Output: false

 Constraints:

 1 <= nums.length <= 5000
 -104 <= nums[i] <= 104
 nums is guaranteed to be rotated at some pivot.
 -104 <= target <= 104
 */

package main.java.array;

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        return find(nums, target, 0, nums.length - 1);
    }

    private boolean find(int[] nums, int target, int l, int r) {
        int mid = (l + r) / 2;

        if (nums[mid] == target || nums[l] == target || nums[r] == target) {
            return true;
        }

        if (l == r) {
            return false;
        }

        if (nums[mid] > nums[l]) {
            if (target < nums[mid] && target > nums[l]) {
                return find(nums, target, l, mid - 1);
            }
        } else if (nums[mid] < nums[l]) {
            if (target > nums[l] || target < nums[mid]) {
                return find(nums, target, l, mid - 1);
            }
        }

        if (nums[mid] < nums[r]) {
            if (target > nums[mid] && target < nums[r]) {
                return find(nums, target, mid + 1, r);
            }
        } else if (nums[mid] > nums[r]) {
            if (target > nums[mid] || target < nums[r]) {
                return find(nums, target, mid + 1, r);
            }
        }

        for (int i = l; i <= r; i++) {
            if (nums[i] == target) {
                return true;
            }
        }

        return false;
    }

}
