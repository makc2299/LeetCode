/**
 A valid number can be split up into these components (in order):

 A decimal number or an integer.
 (Optional) An 'e' or 'E', followed by an integer.
 A decimal number can be split up into these components (in order):

 (Optional) A sign character (either '+' or '-').
 One of the following formats:
 One or more digits, followed by a dot '.'.
 One or more digits, followed by a dot '.', followed by one or more digits.
 A dot '.', followed by one or more digits.
 An integer can be split up into these components (in order):

 (Optional) A sign character (either '+' or '-').
 One or more digits.
 For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].

 Given a string s, return true if s is a valid number.

 Example 1:

 Input: s = "0"
 Output: true
 Example 2:

 Input: s = "e"
 Output: false
 Example 3:

 Input: s = "."
 Output: false

 Constraints:

 1 <= s.length <= 20
 s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.
 */

package main.java.string;

import java.util.HashMap;

public class ValidNumber {

    HashMap<Character, Integer> metOnlyOnce = new HashMap<>();

    public boolean isNumber1(String s) {
        boolean digit, dot, exp;
        digit = dot = exp = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                digit = true;
            } else if (c < 46) {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                if (dot || exp) {
                    return false;
                }
                dot = true;
            } else if (c == 'e' || c == 'E') {
                if (exp || !digit) {
                    return false;
                }
                exp = true;
                digit = false;
            } else {
                return false;
            }
        }

        return digit;
    }

    public boolean isNumber(String s) {
        if (isValidString(s)) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'e' || c == 'E') {
                    return isDecimal(s.substring(0, i)) && isInteger(s.substring(i + 1));
                }
            }
            return isDecimal(s);
        }
        return false;
    }

    public boolean isValidString(String s) {
        int digits = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isAllowedSymbol(c)) {
                if (!Character.isDigit(c)) {
                    c = c < 46 ? 's' : c;
                    if (metOnlyOnce.containsKey(c)) {
                        int val = metOnlyOnce.get(c);

                        if (c == 's' && val < 2) {
                            metOnlyOnce.put(c, 2);
                        } else {
                            return false;
                        }
                    } else {
                        metOnlyOnce.put(c, 1);
                    }
                } else {
                    digits++;
                }
            } else {
                return false;
            }
        }
        metOnlyOnce.clear();

        return digits != 0;
    }

    private boolean isAllowedSymbol(char c) {
        return switch (c) {
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '+', '.', 'e', 'E' -> true;
            default -> false;
        };
    }

    private boolean isDecimal(String s) {
        if (s.isEmpty()) {
            return false;
        }

        int digits = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c < 46) {
                if (sign > 0 && i == 0) {
                    sign--;
                } else {
                    return false;
                }
            } else if (c != '.') {
                digits++;
            }

        }
        return digits > 0;
    }

    public boolean isInteger(String s) {
        if (s.isEmpty()) {
            return false;
        }

        int digits = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c < 46) {
                if (sign > 0 && i == 0) {
                    sign--;
                } else {
                    return false;
                }
            } else if (c == '.') {
                return false;
            } else {
                digits++;
            }

        }
        return digits > 0;
    }
}
