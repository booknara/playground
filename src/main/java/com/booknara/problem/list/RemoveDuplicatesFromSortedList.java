package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 83. Remove Duplicates from Sorted List (Easy)
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(0); // For the first duplicated node
        newHead.next = head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return newHead.next;
    }
}
