package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 226. Invert Binary Tree (Easy)
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {
    // T:O(n), S:O(h)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = temp;

        return root;
    }

    // T:O(n), S:O(h)
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return root;

        traverse(root);
        return root;
    }

    public void traverse(TreeNode node) {
        if (node == null) return;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        traverse(node.left);
        traverse(node.right);
    }

}
