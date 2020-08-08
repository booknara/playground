package com.booknara.problem.search.binary;

import com.booknara.problem.common.TreeNode;

/**
 * 270. Closest Binary Search Tree Value (Easy)
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 */
public class ClosestBinarySearchTreeValue {
    double diff = Double.MAX_VALUE;
    int res = 0;
    // T:O(logn), S:O(logn)
    public int closestValue(TreeNode root, double target) {
        // input check, non-empty tree

        traverse(root, target);

        return res;
    }

    public void traverse(TreeNode node, double target) {
        if (node == null) return;

        // System.out.println(node.val);
        if (Math.abs(node.val - target) < diff) {
            diff = Math.abs(node.val - target);
            res = node.val;
        }
        if (node.val < target) {
            // right
            traverse(node.right, target);
        } else {
            // left
            traverse(node.left, target);
        }
    }
}
