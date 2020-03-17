package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 19. Remove Nth Node From End of List (Medium)
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode f = dummy;
        ListNode s = dummy;
        for (int i = 1; i <= n + 1; i++) {
            f = f.next;
        }

        while (f != null) {
            f = f.next;
            s = s.next;
        }

        s.next = s.next.next;

        return dummy.next;
    }

    // Two pass
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }

        if (len == n) {
            // Remove head node
            return head.next;
        }

        node = head;
        while (node != null) {
            // Find prev node to remove the node
            if (len == n + 1) {
                break;
            }
            node = node.next;
            len--;
        }

        node.next = node.next.next;

        return head;
    }
}
