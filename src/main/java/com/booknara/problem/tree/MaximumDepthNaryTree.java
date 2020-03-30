package com.booknara.problem.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 559. Maximum Depth of N-ary Tree (Easy)
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
public class MaximumDepthNaryTree {
    int maxDepth = 0;
    public int maxDepth(Node root) {
        traverse(root, 1);

        return maxDepth;
    }

    private void traverse(Node node, int depth) {
        if (node == null) {
            return;
        }

        if (depth > maxDepth) {
            maxDepth = depth;
        }

        if (node.children != null && node.children.size() != 0) {
            for (Node n: node.children) {
                traverse(n, depth + 1);
            }
        }
    }

    // Without global variable
    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.children == null || root.children.size() == 0) {
            return 1;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (Node n: root.children) {
            list.add(maxDepth1(n));
        }

        return Collections.max(list) + 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
