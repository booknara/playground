package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 449. Serialize and Deserialize BST (Medium)
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 */
public class SerializeDeserializeBinarySearchTree {
    // Encodes a tree to a single string.
    // T:O(n), S:O(n)
    public String serialize(TreeNode root) {
        // preorder traverse
        StringBuilder builder = new StringBuilder();
        dfsSerialize(root, builder);
        // System.out.println(builder.toString());
        return builder.toString();
    }

    public void dfsSerialize(TreeNode node, StringBuilder builder) {
        if (node == null) return;

        builder.append(node.val);
        if(node.left != null) {
            builder.append(",");
            dfsSerialize(node.left, builder);
        }

        if(node.right != null) {
            builder.append(",");
            dfsSerialize(node.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    // T:O(n), S:O(n)
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        // "2,1,3"
        String[] array = data.split(",");
        Queue<Integer> q = new LinkedList<>();
        for (String s: array) {
            q.offer(Integer.parseInt(s));
        }
        // [2,1,3]
        return dfsDeserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode dfsDeserialize(Queue<Integer> q, int min, int max) {
        if (q.isEmpty()) return null;

        int val = q.peek();
        if (min > val || val > max) return null;

        TreeNode node = new TreeNode(q.poll());
        node.left = dfsDeserialize(q, min, node.val);
        node.right = dfsDeserialize(q, node.val, max);
        /**
         2
         left = dfsDeserialize([1,3], MIN_VALUE, 2);
         1
         left = dfsDeserialize([3], MIN_VALUE, 1);
         right = dfsDeserialize([1,3], MIN_VALUE, 2);
         */

        return node;
    }
}
