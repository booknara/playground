package com.booknara.problem.tree;

import java.util.Stack;

/**
 * 426. Convert Binary Search Tree to Sorted Doubly Linked List (Medium)
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    // T:O(n), S:(h)
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        Node head = null, prev = null;
        // In-order traverse
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (prev == null) {
                // the left most node
                head = root;
            } else {
                root.left = prev;
                prev.right = root;
            }

            // print
            prev = root;
            root = root.right;
        }

        // prev : the right most node
        prev.right = head;
        head.left = prev;

        return head;
    }

    Node first = null, last = null;
    public Node treeToDoublyList1(Node root) {
        if (root == null) {
            return null;
        }

        traverse(root);
        last.right = first;
        first.left = last;
        return first;
    }

    private void traverse(Node node) {
        if (node == null) {
            return;
        }

        traverse(node.left);
        // Main logic to connect the first and last(next) node
        if (last != null) {
            last.right = node;
            node.left = last;
        } else {
            first = node;
        }

        last = node;
        traverse(node.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

}
