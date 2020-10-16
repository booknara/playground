package com.booknara.problem.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 428. Serialize and Deserialize N-ary Tree (Hard)
 * https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/
 */
public class SerializeDeserializeNaryTree {
    // T:O(n), S:O(n)
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return "";

        StringBuilder builder = new StringBuilder();

        helper(root, builder);

        //System.out.println(builder.toString());
        return builder.toString();
    }

    public void helper(Node node, StringBuilder builder) {
        if (node == null) return;

        builder.append(node.val);
        builder.append(",");
        builder.append(node.children.size());
        builder.append(",");
        for (Node n: node.children) {
            helper(n, builder);
        }
    }

    // T:O(n), S:O(n)
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        Queue<Integer> q = new LinkedList<>();
        String[] array = data.split(",");
        for (String s: array) {
            q.offer(Integer.parseInt(s));
        }

        return helper(q);
    }

    public Node helper(Queue<Integer> q) {
        if (q.isEmpty()) return null;

        int val = q.poll();
        int size = q.poll();
        Node node = new Node(val, new ArrayList<>());
        // if size is 0, skip helper() method call
        for (int i = 0; i < size; i++) {
            node.children.add(helper(q));
        }

        return node;
    }

    static class Node {
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
    }
}
