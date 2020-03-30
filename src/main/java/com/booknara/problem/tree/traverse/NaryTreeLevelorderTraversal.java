package com.booknara.problem.tree.traverse;


import java.util.ArrayList;
import java.util.List;

/**
 * 429. N-ary Tree Level Order Traversal (Medium)
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
public class NaryTreeLevelorderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        traverse(root, 0, res);
        return res;
    }

    private void traverse(Node node, int depth, List<List<Integer>> list) {
        if (node == null) {
            return;
        }

        if (list.size() == depth) {
            list.add(new ArrayList<>());
        }

        list.get(depth).add(node.val);
        if (node.children != null && node.children.size() != 0) {
            for (Node c: node.children) {
                traverse(c, depth + 1, list);
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
