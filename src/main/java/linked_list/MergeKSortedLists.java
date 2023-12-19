/**
 You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

 Merge all the linked-lists into one sorted linked-list and return it.

 Example 1:

 Input: lists = [[1,4,5],[1,3,4],[2,6]]
 Output: [1,1,2,3,4,4,5,6]
 Explanation: The linked-lists are:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 merging them into one sorted list:
 1->1->2->3->4->4->5->6
 Example 2:

 Input: lists = []
 Output: []
 Example 3:

 Input: lists = [[]]
 Output: []

 Constraints:

 k == lists.length
 0 <= k <= 104
 0 <= lists[i].length <= 500
 -104 <= lists[i][j] <= 104
 lists[i] is sorted in ascending order.
 The sum of lists[i].length will not exceed 104.
 */

package main.java.linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) {
                    return 1;
                } else if (o1.val < o2.val) {
                    return -1;
                }
                return 0;
            }
        });
        ListNode merged = new ListNode();
        ListNode pointer = merged;

        for (ListNode list : lists) {
            while (list != null) {
                priorityQueue.add(list);
                list = list.next;
            }
        }

        while (priorityQueue.peek() != null) {
            pointer.next = priorityQueue.poll();
            pointer = pointer.next;
            pointer.next = null;
        }

        return merged.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }

        ListNode pointer = new ListNode();
        ListNode merged = pointer;

        for (int nullified = 0; nullified != lists.length; ) {
            nullified = 0;
            int minVal = Integer.MAX_VALUE;
            int minIdx = -1;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    nullified++;
                } else {
                    if (lists[i].val < minVal) {
                        minVal = lists[i].val;
                        minIdx = i;
                    }
                }
            }

            if (nullified != lists.length) {
                pointer.next = lists[minIdx];
                pointer = pointer.next;
                lists[minIdx] = lists[minIdx].next;
            }
        }

        return merged.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }


        for (int i = lists.length - 1; i > 0 ; i--) {
            ListNode merged = new ListNode();
            ListNode mergedHead = merged;

            while (lists[i] != null && lists[i - 1] != null) {
                if (lists[i].val <= lists[i - 1].val) {
                    merged.next = lists[i];
                    lists[i] = lists[i].next;
                } else {
                    merged.next = lists[i - 1];
                    lists[i - 1] = lists[i - 1].next;
                }
                merged = merged.next;
            }

            while (lists[i] != null) {
                merged.next = lists[i];
                lists[i] = lists[i].next;
                merged = merged.next;
            }

            while (lists[i - 1] != null) {
                merged.next = lists[i - 1];
                lists[i - 1] = lists[i - 1].next;
                merged = merged.next;
            }

            lists[i - 1] = mergedHead.next;
        }


        return lists[0];
    }
}
