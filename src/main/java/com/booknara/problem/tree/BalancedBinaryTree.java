package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * Leet code: 110. Balanced Binary tree(easy)
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 *
 * Consider a height-balancing scheme where following conditions should be checked to determine if a binary tree is balanced.
 * An empty tree is height-balanced. A non-empty binary tree T is balanced if:
 * 1) Left subtree of T is balanced
 * 2) Right subtree of T is balanced
 * 3) The difference between heights of left subtree and right subtree is not more than 1.
 */
public class BalancedBinaryTree {
    // Time complexity: O(nlogn), Space complexity: O(n) because of stack
    // Top-down approach
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        return Math.abs(lh - rh) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lHeight = getHeight(node.left) + 1;
        int rHeight = getHeight(node.right) + 1;

        return lHeight > rHeight ? lHeight : rHeight;
    }

    class Height {
        int height;
    }
    // Bottom-up : remove duplicated tree traverse
    public boolean isBalancedOptimzied(TreeNode root) {
        return checkBalance(root, new Height());
    }

    public boolean checkBalance(TreeNode node, Height height) {
        if (node == null) {
            height.height = -1;
            return true;
        }

        Height lHeight = new Height();
        Height rHeight = new Height();
        boolean l = checkBalance(node.left, lHeight);
        boolean r = checkBalance(node.right, rHeight);

        int lh = lHeight.height;
        int rh = rHeight.height;

        height.height = Math.max(lh, rh) + 1;
        if (Math.abs(lh - rh) > 1) {
            return false;
        } else {
            return l & r;
        }
    }
}
