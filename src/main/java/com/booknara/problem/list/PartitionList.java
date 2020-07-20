package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 86. Partition List (Medium)
 * https://leetcode.com/problems/partition-list/
 */
public class PartitionList {
    // T:O(n), S:O(1)
    public ListNode partition(ListNode head, int x) {
        // input check
        if (head == null) return null;

        ListNode groupA = new ListNode(0);
        ListNode groupB = new ListNode(0);
        ListNode curA = groupA;
        ListNode curB = groupB;

        while (head != null) {
            if (head.val < x) {
                // Group A
                curA.next = head;
                curA = curA.next;
            } else {
                // Group B
                curB.next = head;
                curB = curB.next;
            }

            head = head.next;
        }

        // remove cycle
        curB.next = null;
        // tail of groupA -> groupB
        curA.next = groupB.next;

        return groupA.next;
    }
}
