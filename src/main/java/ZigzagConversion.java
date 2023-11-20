/**
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display
 this pattern in a fixed font for better legibility)
 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);

 Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"
 Example 2:

 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 Explanation:
 P     I    N
 A   L S  I G
 Y A   H R
 P     I
 Example 3:

 Input: s = "A", numRows = 1
 Output: "A"

 Constraints:

 1 <= s.length <= 1000
 s consists of English letters (lower-case and upper-case), ',' and '.'.
 1 <= numRows <= 1000
 */

package main.java;
public class ZigzagConversion {

    class Node {
        char value;
        Node next;
        Node() {

        }
        Node(char value) {
            this.value = value;
        }
    }

    class ArrayOfLinkedLists {

        final Node[] array;

        ArrayOfLinkedLists(int size) {
            array = new Node[size];
        }

        public void put(int idx, char symbol) {
            if (array[idx] == null) {
                array[idx] = new Node(symbol);
            } else {
                Node pointer = array[idx];
                while (pointer.next != null) {
                    pointer = pointer.next;
                }
                pointer.next = new Node(symbol);
            }
        }
    }
    public String convert(String s, int numRows) {
        StringBuilder answer = new StringBuilder();
        ArrayOfLinkedLists arrayOfLinkedLists = new ArrayOfLinkedLists(numRows);
        int i = 0, idx = 0, switcher = 0;

        while (i < s.length()) {
            if (idx == numRows) {
                idx--;
            }

            arrayOfLinkedLists.put(idx, s.charAt(i++));

            if (idx == 0) {
                switcher = 1;
            } else if (idx == (numRows - 1)) {
                switcher = -1;
            }

            idx += switcher;
        }

        for (Node node : arrayOfLinkedLists.array) {
            while (node != null) {
                answer.append(node.value);
                node = node.next;
            }
        }
        return answer.toString();
    }
}
