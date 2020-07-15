package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 61. Rotate List (Medium)
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList {
    // T:O(n), S:O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        if (k == 0) return head;

        int size = 0;
        ListNode cur = head;
        ListNode tail = null;
        while (cur != null) {
            size++;
            tail = cur;
            cur = cur.next;
        }

        // System.out.println(size);
        // System.out.println(tail.val);
        k = k % size;
        // edge case (singl element)
        if (size == 1) return head;
        // edge case rotate all the element
        if (k == 0) return head;

        int n = size - k;

        cur = head;
        ListNode prev = null;
        while (n > 0) {
            //System.out.println(cur.val);
            prev = cur;
            cur = cur.next;
            n--;
        }

        prev.next = null;
        tail.next = head;

        return cur;
    }

    public ListNode rotateRight1(ListNode head, int k) {
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
