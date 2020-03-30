package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 1302. Deepest Leaves Sum (Medium)
 * https://leetcode.com/problems/deepest-leaves-sum/
 */
public class DeepestLeavesSum {
    int sum = 0;
    int maxDepth = 0;
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, 1);
        return sum;
    }

    private void dfs(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            if (depth == maxDepth) {
                sum += node.val;
            } else if (depth > maxDepth) {
                maxDepth = depth;
                sum = node.val;
            }

            return;
        }

        if (node.left != null) {
            dfs(node.left, depth + 1);
        }

        if (node.right != null) {
            dfs(node.right, depth + 1);
        }
    }
}
