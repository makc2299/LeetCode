/**
 A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

 For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

 For example, the next permutation of arr = [1,2,3] is [1,3,2].
 Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 Given an array of integers nums, find the next permutation of nums.

 The replacement must be in place and use only constant extra memory.

 Example 1:

 Input: nums = [1,2,3]
 Output: [1,3,2]
 Example 2:

 Input: nums = [3,2,1]
 Output: [1,2,3]
 Example 3:

 Input: nums = [1,1,5]
 Output: [1,5,1]

 Constraints:

 1 <= nums.length <= 100
 0 <= nums[i] <= 100
 */


package main.java;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation3(int[] nums) {
        int i = nums.length - 2;
        int j = i + 1;

        while (i > -1 && nums[i] >= nums[j]) {
            i--;
            j--;
        }

        if (i > -1) {
            int k = nums.length - 1;
            for (; nums[k] <= nums[i]; k--);
            int tmp = nums[k];
            nums[k] = nums[i];
            nums[i] = tmp;
            reverse(nums, i + 1, nums.length - 1);
        } else {
            reverse(nums, 0, nums.length - 1);
        }

    }

    public void reverse(int[] nums, int i, int j) {
        for (; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public void nextPermutation2(int[] nums) {
        int i = nums.length - 2;
        int j = i + 1;

        while (i > -1 && nums[i] >= nums[j]) {
            i--;
            j--;
        }

        if (i > -1) {
            Arrays.sort(nums, j, nums.length);
            for (; nums[i] >= nums[j]; j++);
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        } else {
            Arrays.sort(nums, 0, nums.length);
        }

    }

    public void nextPermutation1(int[] nums) {
        a : {
            for (int i = 0; i <= nums.length - 2; i++) {
                if (nums[i] < nums[i + 1]) {
                    break a;
                }
            }
            Arrays.sort(nums, 0, nums.length);
            return;
        }


        for (int i = nums.length - 2; i >= 0 ; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    Arrays.sort(nums, i + 1, nums.length);
                    int k = i + 1;
                    for (; nums[i] >= nums[k]; k++);
                    int tmp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = tmp;
                    return;
                }
            }
        }

    }

    public void nextPermutation(int[] nums) {
        a : {
            for (int i = 0; i <= nums.length - 2; i++) {
                if (nums[i] < nums[i + 1]) {
                    break a;
                }
            }
            Arrays.sort(nums, 0, nums.length);
            return;
        }


        int nearestLargerIdx, delta;
        for (int i = nums.length - 2; i >= 0 ; i--) {

            delta = Integer.MAX_VALUE;
            nearestLargerIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && (nums[j] - nums[i]) < delta) {
                    delta = nums[j] - nums[i];
                    nearestLargerIdx = j;
                }
            }

            if (nearestLargerIdx != i) {
                int tmp = nums[nearestLargerIdx];
                nums[nearestLargerIdx] = nums[i];
                nums[i] = tmp;

                Arrays.sort(nums, i + 1, nums.length);
                break;
            }
        }

    }
}
