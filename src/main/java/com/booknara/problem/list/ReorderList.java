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
        ListNode halfHead = reverse(slow);

        // Merge the first half and second half
        merge(head, halfHead);
    }

    // T:O(n), S:O(1)
    public void reorderList1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next != null) {
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;

        ListNode reversed = reverse(slow);

        //merge (head, reversed), head is equal or shorter than reversed
        ListNode cur1 = head;
        ListNode cur2 = reversed;
        while (cur1 != null) {
            ListNode fNext = cur1.next;
            ListNode sNext = cur2.next;
            cur1.next = cur2;
            if (fNext == null) {
                break;
            }
            cur2.next = fNext;
            cur1 = fNext;
            cur2 = sNext;
        }
    }

    // Leetcode #206
    private ListNode reverse(ListNode node) {
        ListNode head = node;
        while (node.next != null) {
            ListNode p = node.next;
            node.next = p.next;
            p.next = head;
            head = p;
        }

        return head;
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
