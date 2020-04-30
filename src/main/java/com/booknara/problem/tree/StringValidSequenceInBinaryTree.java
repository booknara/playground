package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/532/week-5/3315/
 */
public class StringValidSequenceInBinaryTree {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null && arr == null) {
            return true;
        }

        if (root == null || arr == null) {
            return false;
        }

        return dfs(root, arr, 0);
    }

    private boolean dfs(TreeNode node, int[] arr, int index) {
        if (node == null) return false;
        if (index == arr.length) return false;  // ouf of bound

        int val = node.val;
        if (val != arr[index]) {
            return false;   // different value node
        }

        if (node.left == null && node.right == null) {
            if (index == arr.length - 1) return true;
            else return false;
        }

        return dfs(node.left, arr, index + 1)
                || dfs(node.right, arr, index + 1);
    }
}
