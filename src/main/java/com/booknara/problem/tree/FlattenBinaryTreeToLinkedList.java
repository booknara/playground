package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.Stack;

/**
 * 114. Flatten Binary Tree to Linked List (Medium)
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {
    // T:O(n), S:O(h)
    public void flatten(TreeNode root) {
        // base case
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        // root
        if (root.left != null) {
            TreeNode right = root.right;
            TreeNode left = root.left;
            root.right = left;

            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
            root.left = null;   // Note: make it null
        }
    }

    public void flatten1(TreeNode root) {
        // input check
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }

            // Key point: check empty stack in case of most end node. And use peek()
            if (!stack.isEmpty()) {
                node.right = stack.peek();
            }

            node.left = null;
        }
    }

    public void flatten2(TreeNode root) {
        getTail(root);
    }

    private TreeNode getTail(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;

        TreeNode leftTail = getTail(node.left);
        TreeNode rightTail = getTail(node.right);

        // node.left, node.right, leftTail, rightTail
        // node.left -> leftTail -> node.right -> rightTail
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail == null ? leftTail : rightTail;
    }

    Stack<TreeNode> stack;
    public void flatten3(TreeNode root) {
        if (root == null) return;

        stack = new Stack<>();
        dfs(root);
    }

    public void dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            if (!stack.isEmpty()) {
                node.right = stack.pop();
                dfs(node.right);
            }
            return;
        }

        if (node.right != null) {
            stack.push(node.right);
        }

        if (node.left != null) {
            node.right = node.left;
            node.left = null;
            dfs(node.right);
        } else {
            node.right = stack.pop();
            dfs(node.right);
        }
    }
}
