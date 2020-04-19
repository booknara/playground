package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 545. Boundary of Binary Tree (Medium)
 * https://leetcode.com/problems/boundary-of-binary-tree/
 */
public class BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> leaf = new ArrayList<>();
        Stack<Integer> right = new Stack<>();
        if (root.left != null) {
            addLeft(root.left, left);
        }

        // Edge case condition in case of one root node only
        if (root.left != null || root.right != null) {
            addLeaf(root, leaf);
        }

        if (root.right != null) {
            addRight(root.right, right);
        }

        res.add(root.val);
        res.addAll(left);
        res.addAll(leaf);
        while (!right.isEmpty()) {
            res.add(right.pop());
        }

        return res;
    }

    private void addLeft(TreeNode node, List<Integer> left) {
        if (node.left == null && node.right == null) {
            return;
        }

        left.add(node.val);
        if (node.left != null) {
            addLeft(node.left, left);
        } else if (node.right != null) {
            addLeft(node.right, left);
        }
    }

    private void addLeaf(TreeNode node, List<Integer> leaf) {
        if (node.left == null && node.right == null) {
            leaf.add(node.val);
            return;
        }

        if (node.left != null) {
            addLeaf(node.left, leaf);
        }
        if (node.right != null) {
            addLeaf(node.right, leaf);
        }
    }

    private void addRight(TreeNode node, Stack<Integer> stack) {
        if (node.left == null && node.right == null) {
            return;
        }

        stack.push(node.val);
        if (node.right != null) {
            addRight(node.right, stack);
        } else if (node.left != null) {
            addRight(node.left, stack);
        }
    }

}
