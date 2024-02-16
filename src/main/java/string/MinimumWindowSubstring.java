/**
 Given two strings s and t of lengths m and n respectively, return the minimum window
 substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

 The testcases will be generated such that the answer is unique.

 Example 1:

 Input: s = "ADOBECODEBANC", t = "ABC"
 Output: "BANC"
 Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 Example 2:

 Input: s = "a", t = "a"
 Output: "a"
 Explanation: The entire string s is the minimum window.
 Example 3:

 Input: s = "a", t = "aa"
 Output: ""
 Explanation: Both 'a's from t must be included in the window.
 Since the largest window of s only has one 'a', return empty string.

 Constraints:

 m == s.length
 n == t.length
 1 <= m, n <= 105
 s and t consist of uppercase and lowercase English letters.


 Follow up: Could you find an algorithm that runs in O(m + n) time?
 */

package main.java.string;

import java.util.*;

public class MinimumWindowSubstring {

    int lS = 0, rS = Integer.MAX_VALUE;
    int[] hash = new int[128];

    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)] += 1;
        }

        int count = t.length();
        for (int r = 0, l = 0; r < s.length(); r++) {
            if (hash[s.charAt(r)]-- > 0) {
                count--;

                while (count == 0) {
                    if (r - l < rS - lS) {
                        rS = r;
                        lS = l;
                    }

                    if (hash[s.charAt(l++)]++ == 0) {
                        count++;
                    }
                }
            }
        }

        return rS > s.length() ? "" : s.substring(lS, rS + 1);
    }

}



