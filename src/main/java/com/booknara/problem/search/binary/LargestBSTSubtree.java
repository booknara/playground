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

        Element leftE = dfs(node.left);
        Element rightE = dfs(node.right);
        if (leftE.size == -1 || rightE.size == -1
                || leftE.max >= node.val || rightE.min <= node.val) {
            // not BST tree
            return new Element(-1, 0, 0);
        }

        int count = leftE.size + leftE.size + 1;
        max = Math.max(max, count);

        return new Element(count, Math.min(leftE.min, node.val), Math.max(leftE.max, node.val));
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
