package com.booknara.problem.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. Populating Next Right Pointers in Each Node (Medium)
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointers {
    // T:O(n), S:O(1)
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node leftAtMost = root;
        while (leftAtMost.left != null) {
            Node node = leftAtMost;
            while (node != null) {
                // left (same parent connection)
                if (node.left != null) {
                    node.left.next = node.right;
                }

                // right (different parent connection)
                if (node.right != null) {
                    if (node.next != null) {
                        node.right.next = node.next.left;
                    }
                }

                node = node.next;
            }

            leftAtMost = leftAtMost.left;
        }

        return root;
    }

    // With Space
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                node.left.next = node.right;
            }
            if (node.right != null) {
                queue.offer(node.right);
                if (node.next != null) {
                    node.right.next = node.next.left;
                }
            }
        }

        return root;
    }

    // T:O(n), S:O(logn)
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        Node prev = null;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                if (prev != null) prev.next = null;
                prev = null;
                queue.offer(null);
                if (queue.peek() == null) break;
                else continue;
            }

            // System.out.println(node.val);
            if (prev != null) {
                prev.next = node;
            }

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

            prev = node;
        }

        return root;
    }

    protected static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}
