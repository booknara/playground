package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 297. Serialize and Deserialize Binary Tree (Hard)
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeDeserializeBinaryTree {
    // Encodes a tree to a single string.
    // T:O(n), S:O(n)
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        dfsSerialize(builder, root);

        return builder.toString();
    }

    public void dfsSerialize(StringBuilder builder, TreeNode node) {
        if (node == null) {
            builder.append("#");
            return;
        }

        builder.append(node.val);
        builder.append(",");
        dfsSerialize(builder, node.left);
        builder.append(",");
        dfsSerialize(builder, node.right);
    }

    // Decodes your encoded data to tree.
    // T:O(n), S:O(n)
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        String[] array = data.split(",");
        int[] pointer = new int[1];
        return dfsDeserialize(array, pointer);
    }

    public TreeNode dfsDeserialize(String[] array, int[] pointer) {
        if (array[pointer[0]].equals("#")) {
            pointer[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(array[pointer[0]]));
        pointer[0]++;
        node.left = dfsDeserialize(array, pointer);
        node.right = dfsDeserialize(array, pointer);

        return node;
    }
}
