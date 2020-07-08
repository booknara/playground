package com.booknara.problem.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. Populating Next Right Pointers in Each Node II (Medium)
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersII {
    // T:O(n), S:O(1)
    Node leftMost;
    Node prev;
    public Node connect(Node root) {
        if (root == null) return root;

        leftMost = root;
        Node cur = leftMost;
        while (leftMost != null) {
            prev = null;
            cur = leftMost;
            leftMost = null;    // note: assign null and reassign when handling child node(pre == null)

            while (cur != null) {
                connectChild(cur.left);
                connectChild(cur.right);
                cur = cur.next;
            }
        }

        return root;
    }

    public void connectChild(Node node) {
        if (node == null) return;

        if (prev == null) {
            leftMost = node;    // left most node at next level
        } else {
            prev.next = node;
        }

        prev = node;
    }

    // T:O(n), S:O(n/2=n, in case of perfect tree)
    public Node connect1(Node root) {
        if (root == null) return root;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int m = q.size();

            Node pre = null;
            // connect the next same level node
            for (int i = 0; i < m; i++) {
                Node n = q.poll();
                // System.out.println(n.val);

                if (pre != null) pre.next = n;

                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);

                pre = n;
            }
        }

        return root;
    }

    static class Node {
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
