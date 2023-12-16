/**
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 Example 1:

 Input: n = 3
 Output: ["((()))","(()())","(())()","()(())","()()()"]
 Example 2:

 Input: n = 1
 Output: ["()"]

 Constraints:

 1 <= n <= 8
 */

package main.java;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    ArrayList<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder tempRes = new StringBuilder();
        addParenthesis(tempRes.append('('), n - 1, n);
        return res;
    }

    private void addParenthesis(StringBuilder tempRes, int opening, int closing) {
        if (opening == 0 && closing == 0) {
            res.add(tempRes.toString());
        } else {
            if (opening != 0) {
                addParenthesis(tempRes.append('('), opening - 1, closing);
                tempRes.deleteCharAt(tempRes.length() - 1);
            }
            if (closing != 0 && closing > opening) {
                addParenthesis(tempRes.append(')'), opening, closing - 1);
                tempRes.deleteCharAt(tempRes.length() - 1);
            }
        }
    }
}
