/**
 Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

 Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 Example 1:

 Input: num1 = "2", num2 = "3"
 Output: "6"
 Example 2:

 Input: num1 = "123", num2 = "456"
 Output: "56088"

 Constraints:

 1 <= num1.length, num2.length <= 200
 num1 and num2 consist of digits only.
 Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */

package main.java.math;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") && num2.equals("0")) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        int lenNum1 = num1.length(), lenNum2 = num2.length();
        int[] arr = new int[lenNum1 + lenNum2];

        for (int i = lenNum2 - 1; i >= 0; i--) {
            int digit = num2.charAt(i) - '0';

            for (int j = lenNum1 - 1; j >= 0 ; j--) {
                int product = (num1.charAt(j) - '0') * digit;
                arr[i + j + 1] += product % 10;
                if (arr[i + j + 1] > 9) {
                    arr[i + j] += (arr[i + j + 1] / 10);
                    arr[i + j + 1] = arr[i + j + 1] % 10;
                }

                arr[i + j] += (product / 10);
                if (arr[i + j] > 9) {
                    arr[i + j - 1] += (arr[i + j] / 10);
                    arr[i + j] = arr[i + j] % 10;
                }
            }

        }

        boolean skipZero = true;
        for (int i = 0; i < arr.length; i++) {
            if (skipZero && arr[i] == 0) {
                continue;
            } else if (arr[i] != 0 && skipZero) {
                skipZero = false;
            }
            stringBuilder.append(arr[i]);
        }

        return stringBuilder.toString();
    }
}
