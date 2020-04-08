package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II (Medium)
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(0); // For the first duplicated node
        newHead.next = head;
        ListNode cur = head;
        ListNode pre = newHead;
        while (cur.next != null) {
            boolean detect = false;
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
                detect = true;
            }

            if (detect) {
                pre.next = cur.next;
                cur = pre.next;
                if (cur == null) break; // Edge case(NPE): 1->1->2->3->3
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return newHead.next;
    }
}
