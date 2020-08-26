package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 865. Smallest Subtree with all the Deepest Nodes (Medium)
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
public class SmallestSubtreeWithAllTheDeepestNodes {
    // input : binary tree
    // output : subtree that contains all the deepest nodes
    // T:O(n), S:O(h)
    // 1. dfs
    // 2. bottom up depth check
    // 3. return TreeNode, depth pair
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // input check
        if (root == null) return null;

        return dfs(root).node;
    }

    public Pair dfs(TreeNode node) {
        // base case
        if (node == null) return new Pair(null, 0);

        Pair left = dfs(node.left);
        Pair right = dfs(node.right);
        if (left.depth == right.depth) {
            return new Pair(node, right.depth + 1);
        }

        if (left.depth < right.depth) {
            return new Pair(right.node, right.depth + 1);
        }

        return new Pair(left.node, left.depth + 1);
    }

    static class Pair {
        TreeNode node;
        int depth;
        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
