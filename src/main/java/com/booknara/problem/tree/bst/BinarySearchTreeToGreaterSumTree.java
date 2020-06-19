package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

import java.util.Stack;

/**
 * 1038. Binary Search Tree to Greater Sum Tree (Medium)
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */
public class BinarySearchTreeToGreaterSumTree {
    // T:O(n), S:O(h)
    public TreeNode bstToGst(TreeNode root) {
        // input check
        if (root == null) return root;

        int total = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                total += cur.val;
                cur = cur.right;
            }
        }

        // System.out.println("total: " + total);

        int remaining = total;
        cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                int temp = cur.val;
                cur.val = remaining;
                remaining -= temp;
                cur = cur.right;
            }
        }

        return root;
    }
}
