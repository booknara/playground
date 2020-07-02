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
}
