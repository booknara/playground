package com.booknara.problem.list;

import java.util.Stack;

/**
 * 430. Flatten a Multilevel Doubly Linked List (Medium)
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
public class FlattenMultilevelDoublyLinkedList {
    // T:O(n), S:O(n)
    public Node flatten(Node head) {
        // input check
        if (head == null) return head;

        Stack<Node> stack = new Stack<>();
        Node cur = head;
        Node prev = null;
        while (cur != null || !stack.isEmpty()) {
            // the end element of each level
            if (cur == null) {
                cur = stack.pop();
                prev.next = cur;
                cur.prev = prev;
            } else {
                // child
                if (cur.child != null) {
                    // Note: push only not null node
                    if (cur.next != null) {
                        stack.push(cur.next);
                    }
                    cur.next = cur.child;
                    cur.child.prev = cur;
                    cur.child = null;
                }
            }

            // System.out.println(cur.val);
            prev = cur;
            cur = cur.next;
        }

        return head;
    }

    public Node flatten1(Node head) {
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
