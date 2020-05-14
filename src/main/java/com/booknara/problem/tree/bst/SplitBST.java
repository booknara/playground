package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

/**
 * 776. Split BST (Medium)
 * https://leetcode.com/problems/split-bst/
 */
public class SplitBST {
    // T:O(n), S:O(h)
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
            return new TreeNode[] {null, null};
        } else if (root.val <= V) {
            // smaller or equal(left) VS larger(right)
            TreeNode[] res = splitBST(root.right, V);
            // res[0]: smaller or equal, res[1] : larger
            root.right = res[0];
            res[0] = root;
            return res;
        } else {
            TreeNode[] res = splitBST(root.left, V);
            root.left = res[1];
            res[1] = root;
            return res;
        }
    }
}
