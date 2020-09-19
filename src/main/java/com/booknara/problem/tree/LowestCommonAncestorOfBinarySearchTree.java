package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree (Easy)
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestorOfBinarySearchTree {
    // T:O(h), S:O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Error handling
        // Make sure that p is smaller than q
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        while (root != null) {
            if (p.val <= root.val && root.val <= q.val) {
                // Case 1: p <= root <= q (answer)
                return root;
            } else if (p.val < root.val && q.val < root.val) {
                // Case 2: p, q < root (left)
                root = root.left;
            } else {
                // Case 3: p, q > root (right)
                root = root.right;
            }
        }

        return null;
    }

    // T:O(h), S:O(1)
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // p, q exist in the tree
        if (root == null) return null;

        int min, max;
        if (p.val < q.val) {
            min = p.val;
            max = q.val;
        } else {
            min = q.val;
            max = p.val;
        }

        while (root != null) {
            if (root.val == p.val || root.val == q.val) return root;
            if (root.val > min && root.val < max) return root;

            if (root.val < min) {
                root = root.right;
            } else if (root.val > max) {
                root = root.left;
            }
        }

        return null;
    }

    // T: O(n), S: O(n)
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // p, q exist in the true
        if (root == null) return null;

        int min, max;
        if (p.val < q.val) {
            min = p.val;
            max = q.val;
        } else {
            min = q.val;
            max = p.val;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.val == min || node.val == max) return node;

                if (min < node.val && node.val < max) return node;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return null;
    }
}
