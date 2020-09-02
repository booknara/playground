package com.booknara.problem.search.binary;

import com.booknara.problem.common.TreeNode;

/**
 * 333. Largest BST Subtree (Medium)
 * https://leetcode.com/problems/largest-bst-subtree/
 */
public class LargestBSTSubtree {
    int max = 0;
    // T:O(n), S:O(h)
    public int largestBSTSubtree(TreeNode root) {
        // input check
        if (root == null) return max;

        dfs(root);
        return max;
    }

    public Element dfs(TreeNode node) {
        if (node == null) {
            // leaf node range [MAX, MIN] because it doesn't accept any range
            return new Element(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Element left = dfs(node.left);
        Element right = dfs(node.right);
        if (left.size == -1 || right.size ==  -1 || node.val <= left.max || right.min <= node.val) {
            // not BST
            return new Element(-1, 0, 0);
        }

        int count = left.size + right.size + 1;
        max = Math.max(max, count);

        return new Element(count, Math.min(left.min, node.val), Math.max(right.max, node.val));
    }

    static class Element {
        int size;
        int min;
        int max;
        Element (int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
}
