/**
 Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

 You may return the answer in any order.

 Example 1:

 Input: n = 4, k = 2
 Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 Explanation: There are 4 choose 2 = 6 total combinations.
 Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 Example 2:

 Input: n = 1, k = 1
 Output: [[1]]
 Explanation: There is 1 choose 1 = 1 total combination.

 Constraints:

 1 <= n <= 20
 1 <= k <= n
 */

package main.java.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        produceComb(n, k, 1, new ArrayList<>());
        return res;
    }

    private void produceComb(int n, int k, int i, ArrayList<Integer> arr) {
        if (k == 0) {
            res.add(new ArrayList<>(arr));
        } else {
            for (; i <= n - k + 1; i++) {
                arr.add(i);
                produceComb(n, k - 1, i + 1, arr);
                arr.remove(arr.size() - 1);
            }
        }
    }
}
