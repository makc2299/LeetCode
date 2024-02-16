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
    int[] hash = new int[58];
    int[] stable = new int[58];
    List<Integer> idxs = new ArrayList<>();
    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            int idx = t.charAt(i) - 'A';
            hash[idx] += 1;
            stable[idx] += 1;
        }

        for (int i = 0; i < stable.length; i++) {
            if (stable[i] != 0) {
                idxs.add(i);
            }
        }

        for (int r = 0, l = 0; r < s.length(); r++) {
            if (stable[s.charAt(r) - 'A'] != 0) {
                hash[s.charAt(r) - 'A'] -= 1;

                while (isDesolated()) {
                    if (r - l < rS - lS) {
                        rS = r;
                        lS = l;
                    }

                    if (stable[s.charAt(l) - 'A'] != 0) {
                        hash[s.charAt(l++) - 'A'] += 1;
                    }
                    while (l < s.length() && stable[s.charAt(l) - 'A'] == 0) {
                        l++;
                    }
                }
            }
        }

        return rS > s.length() ? "" : s.substring(lS, rS + 1);
    }

    public boolean isDesolated() {
        for (int idx : idxs) {
            if (hash[idx] > 0) {
                return false;
            }
        }
        return true;
    }
}



