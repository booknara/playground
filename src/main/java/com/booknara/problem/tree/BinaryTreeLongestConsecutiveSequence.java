package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 298. Binary Tree Longest Consecutive Sequence (Medium)
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 */
public class BinaryTreeLongestConsecutiveSequence {
    // T:O(n), S:O(1)
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        traverse(root);

        return max;
    }

    public int traverse(TreeNode node) {
        if (node == null) return 0;

        int dec = 1;
        if (node.left != null) {
            int left = traverse(node.left);
            if (node.left.val - 1 == node.val) {
                // decrease
                dec = left + 1;
            }
        }

        if (node.right != null) {
            int right = traverse(node.right);
            if (node.right.val - 1 == node.val) {
                // decrease
                dec = Math.max(dec, right + 1);
            }
        }

        max = Math.max(max, dec);

        return dec;
    }
}
