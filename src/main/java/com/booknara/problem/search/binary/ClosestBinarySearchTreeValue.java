package com.booknara.problem.search.binary;

import com.booknara.problem.common.TreeNode;

/**
 * 270. Closest Binary Search Tree Value (Easy)
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 */
public class ClosestBinarySearchTreeValue {
    // T:O(h), S:O(h)
    public int closestValue(TreeNode root, double target) {
        int res = root.val;

        while (root != null) {
            if (Math.abs(res - target) > Math.abs(root.val - target)) {
                res = root.val;
            }

            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return res;
    }

    double diff = Double.MAX_VALUE;
    int res = 0;
    // T:O(n), S:O(n)
    public int closestValue1(TreeNode root, double target) {
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
