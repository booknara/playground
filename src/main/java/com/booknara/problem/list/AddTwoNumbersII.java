package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 445. Add Two Numbers II (Medium)
 * https://leetcode.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        //System.out.println("l1");
        ListNode r1 = reverse(l1);
        //System.out.println("l2");
        ListNode r2 = reverse(l2);

        return reverse(sum(r1, r2));
    }

    public ListNode sum(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while (node1 != null || node2 != null || carry != 0) {
            int num1 = 0;
            if (node1 != null) {
                num1 = node1.val;
                node1 = node1.next;
            }

            int num2 = 0;
            if (node2 != null) {
                num2 = node2.val;
                node2 = node2.next;
            }

            int num = num1 + num2 + carry;
            if (num > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            num = num % 10;
            cur.next = new ListNode(num);
            cur = cur.next;
        }

        return head.next;
    }

    public ListNode reverse(ListNode node) {
        // reverse node. e.g. 1->2->3 => 3->2->1
        ListNode head = node;
        while (node.next != null) {
            ListNode p = node.next;
            node.next = p.next;

            p.next = head;
            head = p;
        }

        return head;
    }
}
