package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 543. Diameter of Binary Tree (Easy)
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterBinaryTree {
    int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        d = 0;
        dfs(root);
        // need to exclude self-node
        return d - 1;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = dfs(node.left);
        int r = dfs(node.right);

        d = Math.max(d, l + r + 1);

        // Return value is "max depth btw left and right + 1(self)"
        return Math.max(l, r) + 1;
    }
}
