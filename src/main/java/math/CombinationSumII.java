/**
 Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

 Each number in candidates may only be used once in the combination.

 Note: The solution set must not contain duplicate combinations.

 Example 1:

 Input: candidates = [10,1,2,7,6,1,5], target = 8
 Output:
 [
 [1,1,6],
 [1,2,5],
 [1,7],
 [2,6]
 ]
 Example 2:

 Input: candidates = [2,5,2,1,2], target = 5
 Output:
 [
 [1,2,2],
 [5]
 ]

 Constraints:

 1 <= candidates.length <= 100
 1 <= candidates[i] <= 50
 1 <= target <= 30
 */

package main.java.math;

import java.util.*;

public class CombinationSumII {

    public ArrayList<List<Integer>> res = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combine(candidates, target, 0);
        return res;
    }

    public void combine(int[] candidates, int target, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(stack));
        } else if (target > 0) {
            int prev = 0;
            for (; i < candidates.length; i++) {
                if (prev == candidates[i]) {
                    continue;
                }
                prev = candidates[i];

                if (target - candidates[i] < 0) {
                    return;
                }
                stack.push(candidates[i]);
                combine(candidates, target - candidates[i], i + 1);
                stack.pop();
            }
        }

    }

}
