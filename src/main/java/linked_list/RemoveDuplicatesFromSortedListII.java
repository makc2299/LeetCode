/**
 Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

 Example 1:

 Input: head = [1,2,3,3,4,4,5]
 Output: [1,2,5]
 Example 2:

 Input: head = [1,1,1,2,3]
 Output: [2,3]

 Constraints:

 The number of nodes in the list is in the range [0, 300].
 -100 <= Node.val <= 100
 The list is guaranteed to be sorted in ascending order.
 */

package main.java.linked_list;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = head, pointerRes;
        ListNode res = new ListNode();
        pointerRes = res;

        boolean marked = false;

        while (pointer != null) {
            if (pointer.next != null) {
                if (pointer.val == pointer.next.val) {
                    pointer = pointer.next;
                    marked = true;
                    continue;
                } else {
                    if (!marked) {
                        pointerRes.next = pointer;
                        pointerRes = pointerRes.next;
                    } else {
                        marked = false;
                    }
                }
            } else {
                if (!marked) {
                    pointerRes.next = pointer;
                }
            }
            pointer = pointer.next;
        }

        if (marked) {
            pointerRes.next = null;
        }

        return res.next;
    }
}
