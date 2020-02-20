package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    public boolean isBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if (min != null && min >= node.val) return false;
        if (max != null && max <= node.val) return false;

        if (!isBST(node.left, min, node.val)) return false;
        if (!isBST(node.right, node.val, max)) return false;

        return true;
    }
}
