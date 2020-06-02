package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 203. Remove Linked List Elements (Easy)
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {
    // T:O(n), S:O(1)
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;
        while (head != null) {
            //System.out.println(current.val);
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }

            head = head.next;
        }

        return newHead.next;
    }
}
