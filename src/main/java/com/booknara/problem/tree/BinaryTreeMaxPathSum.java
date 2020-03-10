package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * Leet code : 124 (Hard)
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaxPathSum {
    int totalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);

        return totalMax;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);

        totalMax = Math.max(totalMax, left + right + node.val);

        return Math.max(left, right) + node.val;
    }
}
