package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 606. Construct String from Binary Tree (Easy)
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 */
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        if (t.left == null && t.right == null) {
            return t.val + "";
        }

        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }

        if (t.left == null) {
            return t.val + "()" + "(" + tree2str(t.right) + ")";
        }

        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }
}
