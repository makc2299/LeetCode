/**
 Given an integer x, return true if x is apalindrome, and false otherwise.

 Example 1:

 Input: x = 121
 Output: true
 Explanation: 121 reads as 121 from left to right and from right to left.
 Example 2:

 Input: x = -121
 Output: false
 Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 Example 3:

 Input: x = 10
 Output: false
 Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 Constraints:

 -231 <= x <= 231 - 1

 Follow up: Could you solve it without converting the integer to a string?
 */

package main.java;
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int len = 1;
        long div = 10;
        while (x / div != 0) {
            len++;
            div *= 10;
        }

        for (int i = 0; i < len / 2; i++) {
            div /= 10;
            if ((x % 10) != (x / div)) {
                return false;
            }
            x %= div;
            x /= 10;
            div /= 10;
        }

        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }

        int len = 0, x2 = x;
        while (x2 != 0) {
            len++;
            x2 /= 10;
        }

        int rightHalf = 0;
        for (int i = 0; i < len / 2; i++) {
            rightHalf = rightHalf * 10 + x % 10;
            x /= 10;
        }

        if (len % 2 != 0) {
            x /= 10;
        }

        return x == rightHalf;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0 || (x!=0 && x%10==0)) {
            return false;
        }

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return (x == rev || x == rev / 10);
    }
}
