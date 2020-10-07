package com.booknara.problem.heap;

import com.booknara.problem.common.ListNode;

import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists (Hard)
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
    // Time Complexity: O(Nlogk), Space Complexity: O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> minQueue = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n1.val, n2.val);
        });

        for (ListNode node: lists) {
            if (node != null) {
                minQueue.offer(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode current = head;
        while(minQueue.size() != 0) {
            ListNode node = minQueue.poll();
            current.next = node;

            if (node.next != null) {
                minQueue.offer(node.next);
            }
            current = current.next;
        }

        return head.next;
    }

    // Time Complexity: O(Nlogk), Space Complexity: O(1)
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        int l = 0, r = lists.length - 1;

        return divide(lists, 0, r);
    }

    public ListNode divide(ListNode[] lists, int l, int r) {
        // base case
        if (l == r) return lists[l];

        int m = l + (r - l) / 2;
        ListNode left = divide(lists, l, m);
        ListNode right = divide(lists, m + 1, r);

        return merge(left, right);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        // remaining node
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;

        return head.next;
    }
}
