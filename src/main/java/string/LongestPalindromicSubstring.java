/**
 Given a string s, return the longest palindromic substring in s.

 Example 1:

 Input: s = "babad"
 Output: "bab"
 Explanation: "aba" is also a valid answer.
 Example 2:

 Input: s = "cbbd"
 Output: "bb"

 Constraints:

 1 <= s.length <= 1000
 s consist of only digits and English letters.
 */

package main.java.string;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int leftIdx = 0, rightIdx = 0, maxLen = 0, startIdx = 0;

        while (leftIdx < s.length()) {

            while (rightIdx < s.length()) {

                m : if (s.charAt(leftIdx) == s.charAt(rightIdx)) {
                    if ((rightIdx - leftIdx + 1) <= maxLen) {
                        break m;
                    }

                    for (int i = leftIdx, j = rightIdx; i < j ; i++, j--) {
                        if (s.charAt(i) != s.charAt(j)) {
                            break m;
                        }
                    }

                    if ((rightIdx - leftIdx + 1) > maxLen) {
                        maxLen = rightIdx - leftIdx + 1;
                        startIdx = leftIdx;
                    }
                }

                rightIdx++;
            }

            rightIdx = ++leftIdx;
            if (maxLen >= (s.length() - leftIdx)) {
                break;
            }
        }
        return s.substring(startIdx, startIdx + maxLen);
    }
}
