/**
 Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

 You must not use any built-in exponent function or operator.

 For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

 Example 1:

 Input: x = 4
 Output: 2
 Explanation: The square root of 4 is 2, so we return 2.
 Example 2:

 Input: x = 8
 Output: 2
 Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

 Constraints:

 0 <= x <= 231 - 1
 */

package main.java.math;

public class SqrtX {

    public int mySqrt(int x) {
        return search(0, 46341, x);
    }

    private int search(int left, int right, int x) {
        if (right - left != 1) {
            int mid = (left + right) / 2;

            int powMid = mid * mid;
            if (powMid == x) {
                return mid;
            } else if (x > powMid) {
                return search(mid, right, x);
            } else {
                return search(left, mid, x);
            }
        }

        return left;
    }
}
