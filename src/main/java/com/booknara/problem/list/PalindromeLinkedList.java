package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 234. Palindrome Linked List (Easy)
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // Find the first second half node using slow/fast pointer
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // For even length list
        if (fast.next != null) {
            slow = slow.next;
        }

        // Reverse second half node
        slow = reverse(slow);

        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }

            slow = slow.next;
            head = head.next;
        }

        return true;
    }

    public ListNode reverse(ListNode node) {
        ListNode curHead = node;
        while (node.next != null) {
            ListNode p = node.next;
            node.next = p.next;
            p.next = curHead;
            curHead = p;
        }

        return curHead;
    }
}
