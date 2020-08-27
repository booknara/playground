package com.booknara.problem.list;

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
            return n1.val - n2.val;
        });

//        PriorityQueue<ListNode> minQueue = new PriorityQueue<>(Comparator.comparing(ListNode::getVal));

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

    // Time Complexity: O(kN), Space Complexity: O(1)
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode last = lists[lists.length - 1];
        for (int i = lists.length - 1; i > 0; i--) {
            last = mergeTwoLists(lists[i - 1], last);
        }

        return last;
    }

    private ListNode mergeTwoLists(ListNode first, ListNode second) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (first != null && second != null) {
            ListNode node;
            if(first.val < second.val) {
                node = first;
                first = first.next;
            } else {
                node = second;
                second = second.next;
            }

            temp.next = node;
            temp = node;
        }

        if (first != null) {
            temp.next = first;
        }
        if (second != null) {
            temp.next = second;
        }

        return head.next;
    }
}
