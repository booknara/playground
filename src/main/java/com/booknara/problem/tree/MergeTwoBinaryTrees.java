package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;
/**
 * 617. Merge Two Binary Trees (Easy)
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class MergeTwoBinaryTrees {
    // Time complexity: O(m)
    public TreeNode mergeTreesBetter(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode node = new TreeNode(t1.val + t2.val);

        node.left = mergeTreesBetter(t1.left, t2.left);
        node.right = mergeTreesBetter(t1.right, t2.right);

        return node;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode root = new TreeNode(0);
        merge(t1, t2, root);

        return root;
    }

    public void merge(TreeNode t1, TreeNode t2, TreeNode node) {
        if (t1 == null && t2 == null) {
            node = null;
            return;
        }

        // node = new TreeNode(0);
        if (t1 != null && t2 != null) {
            node.val = t1.val + t2.val;
            if (t1.left != null || t2.left != null) {
                node.left = new TreeNode(0);
                merge(t1.left, t2.left, node.left);
            }
            if (t1.right != null || t2.right != null) {
                node.right = new TreeNode(0);
                merge(t1.right, t2.right, node.right);
            }
        } else if (t1 != null) {
            node.val = t1.val;
            if (t1.left != null) {
                node.left = new TreeNode(0);
                merge(t1.left, null, node.left);
            }
            if (t1.right != null) {
                node.right = new TreeNode(0);
                merge(t1.right, null, node.right);
            }
        } else {
            node.val = t2.val;
            if (t2.left != null) {
                node.left = new TreeNode(0);
                merge(null, t2.left, node.left);
            }
            if (t2.right != null) {
                node.right = new TreeNode(0);
                merge(null, t2.right, node.right);
            }
        }

        return;
    }

}
