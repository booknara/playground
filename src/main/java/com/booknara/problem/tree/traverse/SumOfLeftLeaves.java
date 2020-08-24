package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

/**
 * 404. Sum of Left Leaves (Easy)
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {
    // T:O(n), S:O(h)
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return res;

        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode node, int branch) {
        // branch : -1(left), 0(root), 1(right)
        if (node.left == null && node.right == null) {
            if (branch == -1) res += node.val;
            return;
        }

        if (node.left != null) dfs(node.left, -1);
        if (node.right != null) dfs(node.right, 1);
    }

    // T:O(n), S:O(h)
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) return 0;

        return dfs(root.left, true) + dfs(root.right, false);
    }

    public int dfs(TreeNode node, boolean left) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) {
            return left ? node.val : 0;
        }

        return dfs(node.left, true) + dfs(node.right, false);
    }
}
