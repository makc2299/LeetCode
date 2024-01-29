/**
 Given the head of a linked list, rotate the list to the right by k places.

 Example 1:

 Input: head = [1,2,3,4,5], k = 2
 Output: [4,5,1,2,3]
 Example 2:

 Input: head = [0,1,2], k = 4
 Output: [2,0,1]

 Constraints:

 The number of nodes in the list is in the range [0, 500].
 -100 <= Node.val <= 100
 0 <= k <= 2 * 109
 */

package main.java.linked_list;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode pointer = head;
        int length = 0;

        while (pointer.next != null) {
            pointer = pointer.next;
            length++;
        }
        pointer.next = head;
        length++;

        int n = length - k % length;

        pointer = head;
        for (int i = 0; i < n; i++) {
            pointer = pointer.next;
        }
        head = pointer;

        while (pointer.next != head) {
            pointer = pointer.next;
        }
        pointer.next = null;

        return head;
    }
}
