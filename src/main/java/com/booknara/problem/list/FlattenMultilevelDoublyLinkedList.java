package com.booknara.problem.list;

import java.util.Stack;

/**
 * 430. Flatten a Multilevel Doubly Linked List (Medium)
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
public class FlattenMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        Node current = head;
        while (current != null) {
            if (current.child != null) {
                // child
                if (current.next != null) {
                    stack.push(current.next);
                }

                current.next = current.child;
                current.next.prev = current;
                current.child = null;

                current = current.next;
            } else {
                // no child
                if (current.next == null && !stack.isEmpty()) {
                    current.next = stack.pop();
                    current.next.prev = current;
                }

                current = current.next;
            }
        }

        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
