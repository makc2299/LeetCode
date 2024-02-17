/**
 Given an integer array nums of unique elements, return all possible
 subsets
 (the power set).

 The solution set must not contain duplicate subsets. Return the solution in any order.

 Example 1:

 Input: nums = [1,2,3]
 Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 Example 2:

 Input: nums = [0]
 Output: [[],[0]]

 Constraints:

 1 <= nums.length <= 10
 -10 <= nums[i] <= 10
 All the numbers of nums are unique.
 */

package main.java.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = Integer.parseInt("1".repeat(nums.length), 2);

        for (int i = 0; i <= n; i++) {
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >>> j) & 1) == 1) {
                    arr.add(nums[j]);
                }
            }
            res.add(arr);
        }
        return res;
    }

}
