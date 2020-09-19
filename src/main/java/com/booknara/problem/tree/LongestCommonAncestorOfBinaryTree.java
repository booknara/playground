package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 236. Lowest Common Ancestor of a Binary Tree (Medium)
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LongestCommonAncestorOfBinaryTree {
    // T: O(n), S: O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root, p, q);
        TreeNode right = lowestCommonAncestor(root, p, q);
        // Not exist p, q under left, right children nodes
        if (left == null && right == null) {
            return null;
        }

        // Exist LCA on the other side
        if (left == null) return right;
        if (right == null) return left;

        // LCA
        return root;
    }

    TreeNode res;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // input check
        if (root == null) return null;

        dfs(root, p, q);
        return res;
    }

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        // base case
        if (node == null) return false;

        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p, q);
        if (left && right) {
            res = node;
            return true;
        }

        if ((right || left) && node.val == p.val) {
            res = node;
            return true;
        }
        if ((right || left) && node.val == q.val) {
            res = node;
            return true;
        }

        return left || right || node.val == p.val || node.val == q.val;
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
