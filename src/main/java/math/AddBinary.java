/**
 Given two binary strings a and b, return their sum as a binary string.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"

 Constraints:

 1 <= a.length, b.length <= 104
 a and b consist only of '0' or '1' characters.
 Each string does not contain leading zeros except for the zero itself.
 */

package main.java.math;

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int app1, app2, tmp, carry = 48;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            app1 = app2 = 48;

            if (i >= 0) {
                app1 = a.charAt(i);
            }

            if (j >= 0) {
                app2 = b.charAt(j);
            }

            tmp = (app1 + app2 + carry) % 48;
            ans.append(tmp % 2);
            carry = tmp / 2 * 49;
        }

        return ans.reverse().toString();
    }

}
