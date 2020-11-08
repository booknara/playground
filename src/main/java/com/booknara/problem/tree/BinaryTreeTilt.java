package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 563. Binary Tree Tilt (Easy)
 * https://leetcode.com/problems/binary-tree-tilt/
 */
public class BinaryTreeTilt {
    int res = 0;
    // T:O(n), S:O(h)
    public int findTilt(TreeNode root) {
        if (root == null) return res;

        helper(root);
        return res;
    }

    public int helper(TreeNode node) {
        // base case
        if (node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);

        res += Math.abs(left - right);

        return left + right + node.val;
    }
}
