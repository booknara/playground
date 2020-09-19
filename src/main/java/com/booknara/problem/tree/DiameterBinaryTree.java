package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 543. Diameter of Binary Tree (Easy)
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return max;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = dfs(node.left);
        int r = dfs(node.right);
        max = Math.max(max, l + r);

        // Return value is "max depth btw left and right + 1(self)"
        return Math.max(l, r) + 1;
    }
}
/**
 with root (3)
 1
 / \
 2   3
 / \
 4   5

 without root (4)
 1
 /
 2
 / \
 4   5
 /     \
 3       6
 */