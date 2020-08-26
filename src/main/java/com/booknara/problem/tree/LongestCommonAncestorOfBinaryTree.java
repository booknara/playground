package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree (Medium)
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LongestCommonAncestorOfBinaryTree {
    // T: O(n), S: O(n)
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

        // Exist LCA on the other side
        if (left == null) return right;
        if (right == null) return left;

        // LCA
        return root;
    }

    TreeNode res;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // input check
        if (root == null) return null;

        dfs(root, p, q);
        return res;
    }

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        // base case
        if (node == null) return false;

        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p, q);
        if (left && right) {
            res = node;
            return true;
        }

        if ((right || left) && node.val == p.val) {
            res = node;
            return true;
        }
        if ((right || left) && node.val == q.val) {
            res = node;
            return true;
        }

        return left || right || node.val == p.val || node.val == q.val;
    }

}
