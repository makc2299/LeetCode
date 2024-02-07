/**
 Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left-justified, and no extra space is inserted between words.

 Note:

 A word is defined as a character sequence consisting of non-space characters only.
 Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 The input array words contains at least one word.


 Example 1:

 Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 Output:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Example 2:

 Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 Output:
 [
 "What   must   be",
 "acknowledgment  ",
 "shall be        "
 ]
 Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 Note that the second line is also left-justified because it contains only one word.
 Example 3:

 Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 Output:
 [
 "Science  is  what we",
 "understand      well",
 "enough to explain to",
 "a  computer.  Art is",
 "everything  else  we",
 "do                  "
 ]

 Constraints:

 1 <= words.length <= 300
 1 <= words[i].length <= 20
 words[i] consists of only English letters and symbols.
 1 <= maxWidth <= 100
 words[i].length <= maxWidth
 */

package main.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {

    List<String> ans = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> fullJustify(String[] words, int maxWidth) {
        String[] buffer = new String[words.length];
        int filled = 0, pureFilled = 0, bufferIdx = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() + filled <= maxWidth) {
                filled += words[i].length();
                pureFilled += words[i].length();
                buffer[bufferIdx++] = words[i];

                if (filled + 1 <= maxWidth) {
                    filled += 1;
                }
            } else {
                ans.add(justifyLine(buffer, bufferIdx, maxWidth, pureFilled));
                stringBuilder.setLength(0);
                bufferIdx = 0;
                filled = 0;
                pureFilled = 0;
                i--;
            }
        }

        ans.add(leftJustifyLine(buffer, bufferIdx, maxWidth, pureFilled));

        return ans;
    }

    private String justifyLine(String[] buffer, int bufferIdx, int maxWidth, int filled) {
        int spaceSlots = bufferIdx > 1 ? bufferIdx - 1 : bufferIdx;
        int[] spaces = new int[spaceSlots];
        Arrays.fill(spaces, (maxWidth - filled) / (spaceSlots));
        int remain = (maxWidth - filled) % (spaceSlots);

        for (int i = 0; remain != 0; i++, remain--) {
            spaces[i] += 1;
        }

        for (int i = 0, j = 0; i < bufferIdx; i++, j++) {
            stringBuilder.append(buffer[i]);
            if (j < spaces.length) {
                stringBuilder.append(" ".repeat(spaces[i]));
            }
        }

        return stringBuilder.toString();
    }

    private String leftJustifyLine(String[] buffer, int bufferIdx, int maxWidth, int filled) {
        int[] spaces = new int[bufferIdx - 1];
        Arrays.fill(spaces, 1);

        int remain = maxWidth - filled - spaces.length;

        for (int i = 0, j = 0; i < bufferIdx; i++, j++) {
            stringBuilder.append(buffer[i]);
            if (j < spaces.length) {
                stringBuilder.append(" ".repeat(spaces[i]));
            }
        }
        stringBuilder.append(" ".repeat(remain));

        return stringBuilder.toString();
    }
}
