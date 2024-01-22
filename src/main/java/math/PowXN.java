/**
 Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 Example 1:

 Input: x = 2.00000, n = 10
 Output: 1024.00000
 Example 2:

 Input: x = 2.10000, n = 3
 Output: 9.26100
 Example 3:

 Input: x = 2.00000, n = -2
 Output: 0.25000
 Explanation: 2-2 = 1/22 = 1/4 = 0.25

 Constraints:

 -100.0 < x < 100.0
 -231 <= n <= 231-1
 n is an integer.
 Either x is not zero or n > 0.
 -104 <= xn <= 104
 */

// helped by https://www.geeksforgeeks.org/fast-exponention-using-bit-manipulation/

package main.java.math;

public class PowXN {

    public double myPow(double x, int n) {
        if (x == 1) {
            return x;
        } else if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }

        double y = 1;
        long mn = n;

        if (n < 0) {
            x = 1 / x;
            mn = -mn;
        }

        while (mn > 0) {

            // check if odd
            if (mn % 2 != 0) {
                y = y * x;
            }

            x *= x;

            mn = mn >> 1;
        }

        return y;
    }
}
