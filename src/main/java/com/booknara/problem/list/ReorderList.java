package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 143. Reorder List (Medium)
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {
    // T:O(n), S:O(1)
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;    // To prevent infinite loop
        // Reverse the second half list
        ListNode halfHead = reverseLinkedList(slow);

        // Merge the first half and second half
        merge(head, halfHead);
    }

    // Leetcode #206
    private ListNode reverseLinkedList(ListNode head) {
        ListNode newHead = head;
        while (head.next != null) {
            ListNode p = head.next;
            head.next = p.next;
            p.next = newHead;
            newHead = p;
        }

        return newHead;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;

            if (n1 == null) break;

            l2.next = n1;   // Key point when l1 reaches null before l2
            l1 = n1;
            l2 = n2;
        }
    }
}
