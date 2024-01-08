/**
 The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

 countAndSay(1) = "1"
 countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.

 For example, the saying and conversion for digit string "3322251":

 Given a positive integer n, return the nth term of the count-and-say sequence.

 Example 1:

 Input: n = 1
 Output: "1"
 Explanation: This is the base case.
 Example 2:

 Input: n = 4
 Output: "1211"
 Explanation:
 countAndSay(1) = "1"
 countAndSay(2) = say "1" = one 1 = "11"
 countAndSay(3) = say "11" = two 1's = "21"
 countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

 Constraints:

 1 <= n <= 30
 */

package main.java;

public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return say(countAndSay(n - 1));
    }

    public String say(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = 0;
        char current = ' ';

        for (int i = 0; i < s.length(); i++) {

            if (current != s.charAt(i)) {
                if (cnt != 0) {
                    stringBuilder.append(cnt);
                    stringBuilder.append(current);
                }
                current = s.charAt(i);
                cnt = 1;
            } else {
                cnt++;
            }
        }

        stringBuilder.append(cnt);
        stringBuilder.append(current);

        return stringBuilder.toString();
    }
}
