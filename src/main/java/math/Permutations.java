/**
 Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 Example 1:

 Input: nums = [1,2,3]
 Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 Example 2:

 Input: nums = [0,1]
 Output: [[0,1],[1,0]]
 Example 3:

 Input: nums = [1]
 Output: [[1]]

 Constraints:

 1 <= nums.length <= 6
 -10 <= nums[i] <= 10
 All the integers of nums are unique.
 */

package main.java.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permutations {

    List<List<Integer>> ans;

    Stack<Integer> stack;
    public List<List<Integer>> permute(int[] nums) {
        int size = 1, n = nums.length;
        while (n != 0) {
            size *= n--;
        }
        ans = new ArrayList<>(size);
        stack = new Stack<>();

        generatePermutation(nums);
        return ans;
    }

    private void generatePermutation(int[] nums) {
        if (stack.size() == nums.length) {
            ans.add(new ArrayList<>(stack));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != -11) {
                    int tmp = nums[i];
                    stack.push(nums[i]);
                    nums[i] = -11;

                    generatePermutation(nums);

                    stack.pop();
                    nums[i] = tmp;
                }
            }
        }
    }
}
