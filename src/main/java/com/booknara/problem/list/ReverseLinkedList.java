package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 206. Reverse Linked List (Easy)
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curHead = head;
        while (head.next != null) {
            // cur : the node to move in front of head
            ListNode p = head.next;
            // skip(remove) the node to move in front of head
            head.next = p.next;

            // Handling to move the node in front of head
            p.next = curHead;
            curHead = p;
        }

        return curHead;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while (head.next != null) {
            // cur : the node to move in front of head
            ListNode cur = head.next;
            // skip(remove) the node to move in front of head
            head.next = cur.next;

            // Handling to move the node in front of head
            cur.next = dummy.next;
            dummy.next = cur;
        }

        return dummy.next;
    }
}
