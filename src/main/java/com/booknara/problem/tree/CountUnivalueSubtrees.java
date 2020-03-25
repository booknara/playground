package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 250. Count Univalue Subtrees (Medium)
 * https://leetcode.com/problems/count-univalue-subtrees/
 */
public class CountUnivalueSubtrees {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return count;
    }

    public boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }

        boolean left = dfs(node.left);
        boolean right = dfs(node.right);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }

            count++;
            return true;
        }

        return false;
    }
}
