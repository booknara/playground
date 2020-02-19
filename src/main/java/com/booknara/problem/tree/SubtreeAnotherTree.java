package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * Leet code : 572. Subtree of Another Tree (Easy()
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
public class SubtreeAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        if ((s.val == t.val) && isSameTree(s, t)) {
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 != null && tree2 != null) {
            return (tree1.val == tree2.val)
                    && isSameTree(tree1.left, tree2.left)
                    && isSameTree(tree1.right, tree2.right);
        }

        return false;
    }
}
