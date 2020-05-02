package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree (Medium)
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LongestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root, p, q);
        TreeNode right = lowestCommonAncestor(root, p, q);
        // Not exist p, q under left, right children nodes
        if (left == null && right == null) {
            return null;
        }

        // Exist LCA the other side
        if (left == null) return right;
        if (right == null) return left;

        // LCA
        return root;
    }
}
