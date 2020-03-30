package com.booknara.problem.tree.traverse;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 590. N-ary Tree Postorder Traversal (Easy)
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */
public class NaryTreePostorderTraversal {
    // Iterative
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.addFirst(node.val);

            if (node.children != null) {
                for (Node child: node.children) {
                    stack.push(child);
                }
            }
        }

        return res;
    }

    // Recursive
    public List<Integer> postorder1(Node root) {
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

        if (node.children != null) {
            for (Node n: node.children) {
                traverse(n, list);
            }
        }
        list.add(node.val);
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
