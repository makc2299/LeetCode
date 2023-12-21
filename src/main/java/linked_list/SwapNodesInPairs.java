/**
 Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 Example 1:

 Input: head = [1,2,3,4]
 Output: [2,1,4,3]
 Example 2:

 Input: head = []
 Output: []
 Example 3:

 Input: head = [1]
 Output: [1]

 Constraints:

 The number of nodes in the list is in the range [0, 100].
 0 <= Node.val <= 100
 */

package main.java.linked_list;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        ListNode beforeHead = new ListNode();
        ListNode tail, tmp;

        tail = head.next.next;
        beforeHead.next = head.next;
        beforeHead.next.next = head;
        head.next = tail;
        while (head.next != null && head.next.next != null) {
            tail = head.next.next.next;
            tmp = head.next;
            head.next = head.next.next;
            head.next.next = tmp;
            tmp.next = tail;
            head = tmp;
        }

        return beforeHead.next;
    }
}
