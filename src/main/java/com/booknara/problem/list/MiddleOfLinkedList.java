package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 876. Middle of the Linked List (Easy)
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // There are two cases
        // i) [1,2,3,4,5] -> fast.next is null. return slow;
        // ii)[1,2,3,4,5,6] -> fast.next is not null. return slow.next;
        return fast.next == null ? slow : slow.next;
    }
}
