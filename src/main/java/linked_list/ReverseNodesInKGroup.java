/**
 Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

 You may not alter the values in the list's nodes, only nodes themselves may be changed.

 Example 1:

 Input: head = [1,2,3,4,5], k = 2
 Output: [2,1,4,3,5]
 Example 2:

 Input: head = [1,2,3,4,5], k = 3
 Output: [3,2,1,4,5]

 Constraints:

 The number of nodes in the list is n.
 1 <= k <= n <= 5000
 0 <= Node.val <= 1000

 Follow-up: Can you solve the problem in O(1) extra memory space?
 */

package main.java.linked_list;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode res = new ListNode();
        ListNode resPointer = res;

        ListNode pointer = head;
        ListNode[] links = new ListNode[k];
        int i = 0;

        while (pointer != null) {

            links[i++] = pointer;
            pointer = pointer.next;

            if (i == links.length) {
                while (i > 0) {
                    resPointer.next = links[i - 1];
                    resPointer = resPointer.next;
                    i--;
                }
            }
        }

        if (i != 0) {
            resPointer.next = links[0];
        } else {
            resPointer.next = null;
        }

        return res.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode beforeHead = new ListNode();
        ListNode pointer = beforeHead, tmp;
        beforeHead.next = head;

        while (pointer.next != null) {
            int swapsNum = k / 2, gap = k - 2;
            for (int i = 0; i < swapsNum; i++) {
                tmp = pointer.next;
                pointer.next = swapTwo(tmp, gap);

                if (tmp.equals(pointer.next)) {
                    return beforeHead.next;
                }
                pointer = pointer.next;
                gap -= 2;
            }

            if (k % 2 != 0) {
                swapsNum++;
            }

            while (swapsNum-- > 0) {
                pointer = pointer.next;
            }
        }

        return beforeHead.next;
    }

    public ListNode swapTwo(ListNode head, int gap) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pointer = head, tmp, tail;

        for (int i = 0; i < gap; i++) {
            pointer = pointer.next;
            if (pointer.next == null) {
                return head;
            }
        }

        if (gap == 0) {
            tail = pointer.next.next;
            tmp = pointer.next;
            head.next = tail;
            tmp.next = head;
        } else {
            tail = pointer.next.next;
            tmp = pointer.next;
            pointer.next = head;
            tmp.next = head.next;
            head.next = tail;
        }

        return tmp;
    }
}
