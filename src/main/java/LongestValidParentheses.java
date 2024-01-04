/**
 Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
 substring
 .

 Example 1:

 Input: s = "(()"
 Output: 2
 Explanation: The longest valid parentheses substring is "()".
 Example 2:

 Input: s = ")()())"
 Output: 4
 Explanation: The longest valid parentheses substring is "()()".
 Example 3:

 Input: s = ""
 Output: 0

 Constraints:

 0 <= s.length <= 3 * 104
 s[i] is '(', or ')'.
 */

package main.java;

import java.util.Arrays;
import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.empty()) {
                    arr[i] = 1;
                    arr[stack.pop()] = 1;
                } else {
                    arr[i] = 0;
                }
            }

        }

        int cnt = 0, com = 0;
        for (int j : arr) {
            if (j == 0) {
                if (com > cnt) {
                    cnt = com;
                }
                com = 0;
            } else {
                com += 1;
            }
        }

        return Math.max(com, cnt);
    }
}
