package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;

/**
 * 449. Serialize and Deserialize BST (Medium)
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 */
public class SerializeDeserializeBinarySearchTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        dfsSerialize(root, builder);

        return builder.toString();
    }

    public void dfsSerialize(TreeNode node, StringBuilder builder) {
        if (node == null) {
            return;
        }

        builder.append(node.val);
        if (node.left != null) {
            builder.append(",");
            dfsSerialize(node.left, builder);
        }
        if (node.right != null) {
            builder.append(",");
            dfsSerialize(node.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] sArray = data.split(",");
        LinkedList<Integer> input = new LinkedList<>();
        for (String s: sArray) {
            input.add(Integer.parseInt(s));
        }

        return dfsDeserialize(input, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode dfsDeserialize(LinkedList<Integer> list, int lower, int higher) {
        if (list.isEmpty()) return null;

        int val = list.peekFirst(); // check point
        if (val < lower || val > higher) return null;

        list.pollFirst();
        TreeNode root = new TreeNode(val);
        root.left = dfsDeserialize(list, lower, val);
        root.right = dfsDeserialize(list, val, higher);

        return root;
    }
}
