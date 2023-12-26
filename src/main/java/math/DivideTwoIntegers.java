/**
 Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

 The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

 Return the quotient after dividing dividend by divisor.

 Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

 Example 1:

 Input: dividend = 10, divisor = 3
 Output: 3
 Explanation: 10/3 = 3.33333.. which is truncated to 3.
 Example 2:

 Input: dividend = 7, divisor = -3
 Output: -2
 Explanation: 7/-3 = -2.33333.. which is truncated to -2.

 Constraints:

 -231 <= dividend, divisor <= 231 - 1
 divisor != 0
 */

package main.java.math;

public class DivideTwoIntegers {

    // https://leetcode.com/problems/divide-two-integers/solutions/142849/c-java-python-should-not-use-long-int/
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = ((dividend >> 31) | ((-dividend) >>> 31)) * ((divisor >> 31) | ((-divisor) >>> 31));
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int quotient = 0, subQuot = 0;
        while (dividend - divisor >= 0) {
            for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++);
            quotient += 1 << subQuot;
            dividend -= divisor << subQuot;
        }

        return quotient * sign;
    }

    public int divide1(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        int sign = ((dividend >> 31) | ((-dividend) >>> 31)) * ((divisor >> 31) | ((-divisor) >>> 31));
        int quotient = 0;

        if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : dividend * -1;
        } else if (dividend == divisor) {
            return 1;
        }

        if (dividend == Integer.MIN_VALUE) {
            if (divisor > 0) {
                dividend += divisor;
            } else {
                dividend -= divisor;
            }
            quotient++;
        } else if (divisor == Integer.MIN_VALUE) {
            return 0;
        }

        int modDividend = Math.abs(dividend);
        int modDivisor = Math.abs(divisor);
        while (modDividend >= modDivisor) {
            modDividend -= modDivisor;
            quotient++;
        }

        return quotient * sign;
    }

}
