package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum (Hard)
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaxPathSum {
    int max = Integer.MIN_VALUE;

    // T:O(n), S:O(h)
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;

        int val = node.val;

        int left = dfs(node.left);
        if (left < 0) left = 0;
        int right = dfs(node.right);
        if (right < 0) right = 0;

        max = Math.max(max, val + left + right);

        return Math.max(left + val, right + val);
    }

    public int dfs2(TreeNode node) {
        if (node == null) return 0;

        int left = dfs2(node.left);
        int right = dfs2(node.right);
        if (left < 0) left = 0;
        if (right < 0) right = 0;

        max = Math.max(max, left + right + node.val);

        int res = Math.max(left, right) + node.val;
        return res < 0 ? 0 : res;
    }
}
