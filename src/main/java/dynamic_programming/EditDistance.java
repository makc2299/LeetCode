/**
 Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

 You have the following three operations permitted on a word:

 Insert a character
 Delete a character
 Replace a character

 Example 1:

 Input: word1 = "horse", word2 = "ros"
 Output: 3
 Explanation:
 horse -> rorse (replace 'h' with 'r')
 rorse -> rose (remove 'r')
 rose -> ros (remove 'e')
 Example 2:

 Input: word1 = "intention", word2 = "execution"
 Output: 5
 Explanation:
 intention -> inention (remove 't')
 inention -> enention (replace 'i' with 'e')
 enention -> exention (replace 'n' with 'x')
 exention -> exection (replace 'n' with 'c')
 exection -> execution (insert 'u')

 Constraints:

 0 <= word1.length, word2.length <= 500
 word1 and word2 consist of lowercase English letters.
 */

package main.java.dynamic_programming;

public class EditDistance {

    int[][] dp;
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()) {
            return Math.max(word1.length(), word2.length());
        } else if (word1.equals(word2)) {
            return 0;
        }
        dp = new int[word1.length() + 1][word2.length() + 1];

        return dp(word1, word2, 0, 0);
    }

    private int dp(String word1, String word2, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i == word1.length()) {
            return word2.length() - j;
        }
        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp(word1, word2, i + 1, j + 1);
        }

        int ins = 1 + dp(word1, word2, i, j + 1);
        int del = 1 + dp(word1, word2, i + 1, j);
        int rep = 1 + dp(word1, word2, i + 1, j + 1);

        int dist = Math.min(Math.min(ins, del), rep);
        dp[i][j] = dist;

        return dist;
    }
}
