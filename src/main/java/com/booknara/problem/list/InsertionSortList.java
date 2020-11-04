package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 147. Insertion Sort List (Medium)
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class InsertionSortList {
    // T:O(n^2), S:O(1)
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = head;

        while (cur.next != null) {
            if (cur.val > cur.next.val) {
                // insert node before cur.next node
                ListNode next = cur.next;
                cur.next = cur.next.next;
                insert(res, next);
            } else {
                cur = cur.next;
            }
        }

        return res.next;
    }

    public void insert(ListNode res, ListNode cur) {
        ListNode t = res;
        while (t.next != null && t.next.val < cur.val) {
            t = t.next;
        }

        ListNode next = t.next;
        t.next = cur;
        cur.next = next;
    }

    // T:O(n^2), S:O(n)
    public ListNode insertionSortList1(ListNode head) {
        if (head == null) return head;

        ListNode res = new ListNode(0);
        while (head != null) {
            // Create an instance
            ListNode node = new ListNode(head.val);
            //System.out.println(node.val);

            ListNode cur = res;
            boolean inserted = false;
            while (cur.next != null) {
                if (node.val < cur.next.val) {
                    // insert node before cur.next node
                    node.next = cur.next;
                    cur.next = node;
                    inserted = true;
                    break;
                }
                cur = cur.next;
            }

            if (!inserted) {
                cur.next = node;
            }

            head = head.next;
        }

        return res.next;
    }
}
