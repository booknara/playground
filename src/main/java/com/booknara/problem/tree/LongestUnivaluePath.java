package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 687. Longest Univalue Path (Easy)
 * https://leetcode.com/problems/longest-univalue-path/
 */
public class LongestUnivaluePath {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return max;
    }

    public int dfs(TreeNode node) {
        int l = node.left != null ? dfs(node.left) : 0;
        int r = node.right != null ? dfs(node.right) : 0;

        int resl;
        if (node.left != null && node.val == node.left.val) {
            resl = l + 1;
        } else {
            resl = 0;
        }

        int resr;
        if (node.right != null && node.val == node.right.val) {
            resr = r + 1;
        } else {
            resr = 0;
        }

        max = Math.max(max, resl + resr);
        return Math.max(resl, resr);
    }
}
