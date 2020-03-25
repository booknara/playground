package com.booknara.problem.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. Populating Next Right Pointers in Each Node (Medium)
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointers {
    // Without Space
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node leftMost = root;
        while (leftMost.left != null) {
            Node head = leftMost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }

            leftMost = leftMost.left;
        }

        return root;
    }

    // With Space
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node node = root;
        int count = 1;
        while (!queue.isEmpty()) {
            Node pre = node;
            node = queue.poll();
            if (isPower(count)) {
                // System.out.println("count : " + count + " " + node.val);
                pre.next = null;
            } else {
                pre.next = node;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
            count++;
        }

        return root;
    }

    private boolean isPower(int num) {
        return num > 0 && (num & num - 1) == 0;
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
