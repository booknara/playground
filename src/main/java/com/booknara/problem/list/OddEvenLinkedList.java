package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 328. Odd Even Linked List (Medium)
 * https://leetcode.com/problems/odd-even-linked-list/
 */
public class OddEvenLinkedList {
    // T:O(n), S:O(1)
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public ListNode oddEvenList1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode odd = new ListNode(0);
        ListNode oddHead = odd;
        ListNode even = new ListNode(0);
        ListNode evenHead = even;
        boolean toggle = true;
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            System.out.println(head.val);
            ListNode node = head;
            pre.next = node.next;
            if (toggle) {
                // Odd
                odd.next = node;
                odd = odd.next;
            } else {
                // Even
                even.next = node;
                even = even.next;
            }

            toggle = !toggle;
            pre = head;
            head = head.next;
        }

        odd.next = evenHead.next;

        return oddHead.next;
    }
}
