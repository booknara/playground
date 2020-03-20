package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 61. Rotate List (Medium)
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;   // Point: to remember tail node
        ListNode cur = head.next;

        int size = 1;
        // One pass to know the size of list
        while (cur != null) {
            size++;
            tail = cur;
            cur = cur.next;
        }

        // For the case that k is larger than size
        int mod = k % size;
        if (mod == 0) {
            return head;
        }

        int step = size - mod;
        ListNode prev = head;
        cur = head;
        // To find the new head after the rotation
        while (cur != null) {
            if (step == 0) {
                break;
            }
            prev = cur;
            cur= cur.next;
            step--;
        }

        prev.next = null;
        tail.next = head;
        return cur;
    }
}
