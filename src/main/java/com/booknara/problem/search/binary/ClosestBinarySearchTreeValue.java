package com.booknara.problem.search.binary;

import com.booknara.problem.common.TreeNode;

import java.util.Stack;

/**
 * 270. Closest Binary Search Tree Value (Easy)
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 */
public class ClosestBinarySearchTreeValue {
    // T:O(h), S:O(h)
    public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;

        // Binary search
        int res = root.val;
        while (root != null) {
            res = Math.abs(target - res) > Math.abs(target - root.val) ? root.val : res;

            if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
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

    // T:O(n), S:O(n)
    public int closestValue2(TreeNode root, double target) {
        if (root == null) return 0;

        Integer res = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            if (target == node.val) return node.val;

            if (target < node.val) {
                if (res == null) return node.val;   // the target is smaller than the smallest value

                // get the answer btw the existing and node.val
                if (target - res < node.val - target) {
                    return res;
                }
                return node.val;
            }

            // target is bigger than node.val
            res = node.val;
            // System.out.println(node.val);
            cur = node.right;
        }

        return res;
    }

}
