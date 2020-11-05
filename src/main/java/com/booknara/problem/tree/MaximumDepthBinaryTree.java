package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree (Easy)
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthBinaryTree {
    // T:O(n), S:O(h)
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;

        return Math.max(left, right);
    }
}
