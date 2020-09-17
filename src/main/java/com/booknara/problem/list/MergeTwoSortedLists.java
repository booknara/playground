package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 21. Merge Two Sorted Lists (Easy)
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    // T:O(n + m), S:O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                // add l1 to cur
                cur.next = l1;
                l1 = l1.next;
            } else {
                // add l2 to cur
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return head.next;
    }
}
