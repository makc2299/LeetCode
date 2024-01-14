/**
 Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).
 The matching should cover the entire input string (not partial).

 Example 1:

 Input: s = "aa", p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".
 Example 2:

 Input: s = "aa", p = "*"
 Output: true
 Explanation: '*' matches any sequence.
 Example 3:

 Input: s = "cb", p = "?a"
 Output: false
 Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

 Constraints:

 0 <= s.length, p.length <= 2000
 s contains only lowercase English letters.
 p contains only lowercase English letters, '?' or '*'.
 */

package main.java.dynamic_programming;

public class WildcardMatching {

    int[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new int[s.length() + 3][p.length() + 3];
        return match(s, 0, p, 0);
    }

    private boolean match(String s, int sIdx, String p, int pIdx) {
        if (memo[sIdx][pIdx] != 0) {
            return memo[sIdx][pIdx] == 1;
        }

        if (sIdx == s.length() && pIdx == p.length()) {
            return true;
        } else if (sIdx != s.length() && pIdx == p.length()) {
            return false;
        }

        if (p.charAt(pIdx) == '?') {
            return addToMemo(sIdx, pIdx, match(s, sIdx + 1, p, pIdx + 1) ? 1 : -1);
        }

        if (p.charAt(pIdx) == '*') {
            for (; sIdx <= s.length(); sIdx++) {

                if (addToMemo(sIdx, pIdx, match(s, sIdx, p, pIdx + 1) ? 1 : -1)) {
                    return true;
                }
            }
        }

        if (sIdx < s.length() && s.charAt(sIdx) == p.charAt(pIdx)) {
            return addToMemo(sIdx, pIdx, match(s, sIdx + 1, p, pIdx + 1) ? 1 : -1);
        }

        return false;
    }

    private boolean addToMemo(int i, int j, int b) {
        memo[i][j] = b;
        return b == 1;
    }
}
