package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 112. Path Sum (Easy)
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return dfs(root, 0, sum);
    }

    public boolean dfs(TreeNode node, int middle, int sum) {
        if (node.left == null && node.right == null) {
            return (middle + node.val) == sum;
        }

        if (node.left != null && node.right != null) {
            return dfs(node.left, middle + node.val, sum)
                    || dfs(node.right, middle + node.val, sum);
        }

        if (node.left != null) {
            return dfs(node.left, middle + node.val, sum);
        }

        return dfs(node.right, middle + node.val, sum);
    }
}
