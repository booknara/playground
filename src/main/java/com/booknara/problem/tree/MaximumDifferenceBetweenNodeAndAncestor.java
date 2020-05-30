package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 1026. Maximum Difference Between Node and Ancestor (Medium)
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    // T:O(n), S:O(h)
    int totalMax = 0;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;

        dfs(root, root.val, root.val);

        return totalMax;
    }

    // maintain min, max value from top to bottom
    public void dfs(TreeNode node, int min, int max) {
        if (node == null) return;

        totalMax = Math.max(totalMax,
                Math.max(Math.abs(node.val - min), Math.abs(node.val - max)));

        if (node.val < min) {
            min = node.val;
        } else if (node.val > max) {
            max = node.val;
        }

        dfs(node.left, min, max);
        dfs(node.right, min, max);
    }
}
