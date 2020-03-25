package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree (Easy)
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root);
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        return Math.max(left, right) + 1;
    }
}
