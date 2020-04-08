package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 2. Add Two Numbers (Medium)
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // l1, l2 is non-empty linked list
        ListNode current = new ListNode(0);
        ListNode head = current;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int num1 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }

            int num2 = 0;
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }

            int sum = num1 + num2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            current.next = node;
            current = node;
        }

        return head.next;
    }
}
