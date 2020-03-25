package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 100. Same Tree (Easy)
 * https://leetcode.com/problems/same-tree/
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }


}
