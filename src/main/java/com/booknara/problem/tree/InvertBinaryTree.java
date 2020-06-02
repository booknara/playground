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
}
