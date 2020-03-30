package com.booknara.problem.tree.traverse;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N-ary Tree Preorder Traversal (Easy)
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */
public class NaryTreePreorderTraversal {
    // Iterative
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }

        return res;
    }

    // Recursive
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        traverse(root, res);
        return res;
    }

    private void traverse(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        if (node.children != null) {
            for (Node n: node.children) {
                traverse(n, list);
            }
        }
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
