package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

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

        builder.append(node.val).append(",");
        dfsSerialize(node.left, builder);
        dfsSerialize(node.right, builder);

        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] array = data.split(",");
        int[] pointer = new int[1];
        return dfsDeserialize(array, pointer, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode dfsDeserialize(String[] array, int[] pointer,
                                   int min, int max) {
        if (pointer[0] == array.length) {
            return null;
        }

        int val = Integer.parseInt(array[pointer[0]]);
        if (val < min || val > max) {
            return null;
        }

        TreeNode node = new TreeNode(val);
        pointer[0]++;
        node.left = dfsDeserialize(array, pointer, min, val);   // smaller than root
        node.right = dfsDeserialize(array, pointer, val, max);  // bigger than root

        return node;
    }
}
