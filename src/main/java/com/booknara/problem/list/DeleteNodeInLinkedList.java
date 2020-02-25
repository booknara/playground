package com.booknara.problem.list;

import com.booknara.problem.common.ListNode;

/**
 * 237. Delete Node in a Linked List (Easy)
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
