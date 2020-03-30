package com.booknara.problem.tree;

/**
 * 426. Convert Binary Search Tree to Sorted Doubly Linked List (Medium)
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    Node first = null, last = null;
    public Node treeToDoublyList(Node root) {
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
