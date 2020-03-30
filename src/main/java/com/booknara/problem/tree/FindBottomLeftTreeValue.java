package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 513. Find Bottom Left Tree Value (Medium)
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeftTreeValue {
    int leftmost = 0;
    int maxDepth = 0;
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, 1);
        return leftmost;
    }

    private void dfs(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                leftmost = node.val;
            }

            return;
        }

        // Key point: to traverse from left node
        if (node.left != null) {
            dfs(node.left, depth + 1);
        }

        if (node.right != null) {
            dfs(node.right, depth + 1);
        }
    }

}
